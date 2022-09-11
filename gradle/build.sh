#!/usr/bin/env bash

set +x
set -e

generateGitProperties () {
  echo
  echo "[8%] Generating git.properties..."
  gradle clean generateGitProperties -q -x compileJava 2> /dev/null
  echo
  cat ./build/resources/main/git.properties
  cp ./build/resources/main/git.properties ./build/resources/main/pre-tag-git.properties
}

generateGradleProperties () {
  generateGitProperties
  echo
  echo "[10%] Generating gradle.properties..."
  sed -n s,"buildInfo.build.number=local","buildInfo.build.number=$CODEBUILD_BUILD_NUMBER", ./gradle.properties
  cp ./gradle.properties ./build/resources/main/gradle.properties
}

maskToken () {
  grep -wv CODEARTIFACT_AUTH_TOKEN ./build/resources/main/build.properties.unsafe > ./build/resources/main/build.properties
}

generateBuildProperties () {
  generateGradleProperties
  echo
  echo "[12%] Generating build.properties..."
  printenv > ./build/resources/main/build.properties.unsafe
  maskToken
}

generateBuildNumberProperties () {
  generateBuildProperties
  echo
  echo "[14%] Generating buildNumber.properties..."
  echo "$CODEBUILD_BUILD_NUMBER" > ./build/resources/main/buildNumber.properties
}

resolveDestinationRepository () {
  generateBuildNumberProperties
  echo
  echo "[16%] Resolving target ECR repository URI..."
  tags=$(git tag)
  if [ -z "$tags" ];
  then
    export DOCKER_REPOSITORY='snapshots'
  else
    IMAGE_TAG=$(git describe --tags)
    LATEST_TAG=$(git describe --abbrev=0 --tags)
    if [[ "$IMAGE_TAG" == "$LATEST_TAG" ]];
    then
      export DOCKER_REPOSITORY='releases'
    else
      export DOCKER_REPOSITORY='snapshots'
    fi
  fi
}

generateJibEnvProperties () {
  resolveDestinationRepository
  echo
  echo "[18%] Generating jibEnv.properties..."
  JIB_ENVIRONMENT_VARIABLES="CODEBUILD_BUILD_NUMBER=${CODEBUILD_BUILD_NUMBER},\
  CI_COMMIT_BRANCH=${CODEBUILD_SOURCE_VERSION},\
  CI_COMMIT_SHA=${CODEBUILD_RESOLVED_SOURCE_VERSION},\
  CI_COMMIT_TAG=${IMAGE_TAG}"
  echo "$JIB_ENVIRONMENT_VARIABLES" > ./build/resources/main/jibEnv.properties
}

generateJvmArgsProperties () {
  generateJibEnvProperties
  echo
  echo "[20%] Generating jvmArgs.properties..."
  JVM_ARGS="-PbuildNumber=${CODEBUILD_BUILD_NUMBER}"
  echo "$JVM_ARGS" > ./build/resources/main/jvmArgs.properties
}

generateBuildStartTimeProperties () {
  generateJvmArgsProperties
  echo
  echo "[22%] Generating buildStartTime.properties..."
  date > ./build/resources/main/buildStartTime.properties
}

findCurrentGitBranch () {
  generateBuildStartTimeProperties
  echo
  echo "[24%] Resolving Git branch..."
  echo
  /home/git/find-current-branch.sh
}

setVersionInBuildGradle () {
  findCurrentGitBranch
  echo
  echo "[26%] Resolving version..."
  /home/git/set-version.sh
}

resolveEcrCoordinates () {
  setVersionInBuildGradle
  echo
  echo "[28%] Resolving target ECR coordinates..."
  echo
  echo -e "host:\t\t$HOST"
}

resolveEcrRepo () {
  resolveEcrCoordinates
  echo -e "repo:\t\t$DOCKER_REPOSITORY"
}

echoGroupId () {
  resolveEcrRepo
  groupId=$(gradle rootProjectGroupRaw -q | tr '.' '/')
  echo -e "group:\t\t$groupId"
}

echoArtifactId () {
  echoGroupId
  artifactId=$(gradle rootProjectNameRaw -q)
  echo -e "artifact:\t$artifactId"
}

echoGradleVersion () {
  echoArtifactId
  version=$(gradle rootProjectVersionRaw -q)
  echo -e "version:\t$version"
}

generateTestReport () {
  echoGradleVersion
  echo
  echo "[33%] Running unit tests..."
  gradle test jacocoTestReport
}

buildNativeImage () {
  generateTestReport
  echo
  echo "[51%] Building image: $HOST/$DOCKER_REPOSITORY/$groupId/$artifactId:$version..."
  echo
  gradle build -x test \
  -Dquarkus.package.type=native \
  -Dquarkus.native.container-build=false \
  -Dquarkus.native.container-runtime=docker \
  -Dquarkus.native.java-home="$GRAALVM_HOME" \
  -Dquarkus.native.native-image-xmx="$buildComputeXmx" \
  -Dquarkus.jib.always-cache-base-image=true \
  -Dquarkus.jib.base-native-image="$runtimeImage" \
  -Dquarkus.container-image.builder=jib \
  -Dquarkus.container-image.build=true \
  -Dquarkus.container-image.push=true \
  -Dquarkus.container-image.name="$artifactId" \
  -Dquarkus.container-image.group="$DOCKER_REPOSITORY"/"$groupId" \
  -Dquarkus.container-image.registry="$HOST" \
  -Dquarkus.container-image.additional-tags=latest
}

buildNativeImage
