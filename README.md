# Quarkus JPA Example

last updated: Sun Sep 11 23:05:21 CEST 2022

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Table of Contents:

- [1. How to clone:](#1-how-to-clone)
- [2. Running the application in dev mode](#2-running-the-application-in-dev-mode)
- [3. Packaging and running the application](#3-packaging-and-running-the-application)
- [4. Creating a native executable](#4-creating-a-native-executable)
- [5. how to create a docker image locally:](#5-how-to-create-a-docker-image-locally)
  - [5.1. running inside another docker image (known as container build)](#51-running-inside-another-docker-image-known-as-container-build)
  - [5.2. using your own GraalVM](#52-using-your-own-graalvm)
- [6. How to start with Docker](#6-how-to-start-with-docker)
- [7. Docker examples](#7-docker-examples)
  - [7.1. how to run Quarkus from docker container with custom `application.yml` mount](#71-how-to-run-quarkus-from-docker-container-with-custom-applicationyml-mount)
    - [7.1.1. Sample `application-docker.yml` with a password](#711-sample-application-dockeryml-with-a-password)
  - [7.2. how to run Quarkus from docker container with custom `application.yml` mount and a password](#72-how-to-run-quarkus-from-docker-container-with-custom-applicationyml-mount-and-a-password)
    - [7.2.1. Sample `application-docker.yml` without a password](#721-sample-application-dockeryml-without-a-password)
  - [7.3. how to run Quarkus from docker container without mounting `application.yml`](#73-how-to-run-quarkus-from-docker-container-without-mounting-applicationyml)
  - [7.4. how to build your own docker image](#74-how-to-build-your-own-docker-image)
    - [7.4.1. how to run a snapshot](#741-how-to-run-a-snapshot)
    - [7.4.2. how to open a docker image](#742-how-to-open-a-docker-image)
    - [7.4.3. Sample `application-docker.yml` with a password](#743-sample-application-dockeryml-with-a-password)
- [8. How to bump a version?](#9-how-to-bump-a-version)
  - [8.1. Add a new tag](#91-add-a-new-tag)
- [9. Related Guides](#10-related-guides)
- [10. Including resources](#11-including-resources)
  - [10.1. Including resources](#111-including-resources)

## 1. How to clone:

```bash
git clone git@github.com:lukaszochmanski/quarkus-jpa-example.git \
~/Workspace/de/ochmanski/microservices/quarkus/quarkus-jpa-example
```

## 2. Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```bash script
gradle quarkusDev
```

alternatively, you may call:

```bash script
quarkus dev
```

The second call will work, if you have Quarkus SDK installed:

```bash
sdk install quarkus
```

to test:

```bash script
curl -w "\n" http://localhost:8080/hello
curl http://localhost:8080/q/health/live
curl http://localhost:8080/q/health/ready
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.
> 
## 3. Packaging and running the application

The application can be packaged using:

```bash script
gradle build
```

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.  
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```bash script
gradle build -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## 4. Creating a native executable

You can create a native executable using:

```bash script
gradle build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```bash script
gradle build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/code-with-quarkus-1.0.2-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling.  

## 5. how to create a docker image locally:

### 5.1. running inside another docker image (known as container build)

In this case the default image `quay.io/quarkus/ubi-quarkus-native-image:22.0-java11` will be used.

This can be changed in `build.gradle` file:

```groovy
quarkusBuild {
  nativeArgs {
    containerBuild = true
    builderImage = "quay.io/quarkus/ubi-quarkus-native-image:22.0.0-java11"
    containerRuntime = "docker"
  }
}
```

or:

```groovy
quarkusBuild {
  nativeArgs {
    containerBuild = true
    builderImage = "base/images/red-hat/red-hat-8-5/quay-io/quarkus/quarkus-micro-image:1.0.5"
    containerRuntime = "docker"
  }
}
```

command to execute:

```bash
GRAALVM_HOME='$HOME/.sdkman/candidates/java/22.1.0.r17-grl'
groupId='de/ochmanski/microservices/iam/sso-iam'
artifactId='quarkus-jpa-example'
DOCKER_REPOSITORY="snapshots"
gradle build \
    -Dquarkus.package.type=native \
    -Dquarkus.native.container-build=true \
    -Dquarkus.native.container-runtime=docker \
    -Dquarkus.native.java-home=${GRAALVM_HOME} \
    -Dquarkus.native.native-image-xmx=7G \
    -Dquarkus.jib.always-cache-base-image=true \
    -Dquarkus.container-image.builder=jib \
    -Dquarkus.container-image.build=true \
    -Dquarkus.container-image.push=false \
    -Dquarkus.container-image.name=${artifactId} \
    -Dquarkus.container-image.group=${DOCKER_REPOSITORY}/${groupId} \
    -Dquarkus.container-image.registry=${HOST}
```

### 5.2. using your own GraalVM

It is a recommended way of building the project.  
Main advantage of this method is that it doesn't require docker
installation, and it works fully offline. However, it requires more maintenance, expertise and
initial effort, to configure the environment. But you need to do it only once.  
This method is faster because it has less virtualization layers, than the `container build method` described in section
[5.1.](#51-running-inside-another-docker-image-known-as-container-build)
It is running directly in your OS, without the Docker service. Therefore, it also consumes less memory, and less CPU.  
As everything that is not virtualized, comes with a price.  
This solution is not as portable, as the solution presented above
in [5.1.](#51-running-inside-another-docker-image-known-as-container-build).

As of writing this document, it only works on Linux platform. If you use Windows, or MacOS, you may face problems.   
This option requires you to install `native-image` first:

```bash
sdk install java java=22.1.0.r17-grl
GRAALVM_HOME=$HOME/.sdkman/candidates/java/22.1.0.r17-grl
$GRAALVM_HOME/bin/gu install native-image
sdk install quarkus
```

and execute the build:

```bash
quarkus build --native
```

a similar command for gradle users:

```bash
groupId='de/ochmanski/microservices/iam/sso-iam'
artifactId='quarkus-jpa-example'
DOCKER_REPOSITORY="snapshots"
gradle build \
    -Dquarkus.package.type=native \
    -Dquarkus.native.container-build=false \
    -Dquarkus.native.container-runtime=docker \
    -Dquarkus.native.java-home=${GRAALVM_HOME} \
    -Dquarkus.native.native-image-xmx=7G \
    -Dquarkus.jib.always-cache-base-image=true \
    -Dquarkus.container-image.builder=jib \
    -Dquarkus.container-image.build=true \
    -Dquarkus.container-image.push=false \
    -Dquarkus.container-image.name=${artifactId} \
    -Dquarkus.container-image.group=${DOCKER_REPOSITORY}/${groupId} \
    -Dquarkus.container-image.registry=${HOST}
```

Note that running the command in MacOS or in Windows will result in the following error:

```bash
> Task :quarkusBuild FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':quarkusBuild'.
> io.quarkus.builder.BuildException: Build failure: Build failed due to errors
        [error]: Build step io.quarkus.container.image.jib.deployment.JibProcessor#buildFromNative threw an exception: java.lang.RuntimeException: 
        The native binary produced by the build is not a Linux binary and therefore cannot be used in a Linux container image. 
        Consider adding "quarkus.native.container-build=true" to your configuration
```

The reason why it doesn't work, is that it can only run inside a true Linux, or inside another docker image.
If you try to build it inside a docker container, you will not see this error. This is exactly the case in our CI
environment.  
We run our build pipelines inside another Docker container. You may find details in `buildspec.yml` file.

```bash
-Dquarkus.native.container-build=false
```

## 6. How to start with Docker

This option is good for someone that is not a java developer and wants runtime environment quickly.

```bash
docker run --rm -p 8080:8080 --name="quarkus-jpa-example-1.0.2" -it ../releases/de/ochmanski/microservices/quarkus-jpa-example:1.0.2
```

However, this will probably not work, because the database url is not the same inside a docker container.  
One solution is to open the container and install mysql database there.  
Another solution is to use the database that already exists on your machine.  
A third solution would be to connect to our dev database instance.  
Instruction steps are given in point 7.

## 7. Docker examples
Below, I present a few examples, how running the app can be achieved without installing java.
### 7.1. how to run Quarkus from docker container with custom `application.yml` mount

```bash
cd $AWS/de/ochmanski/microservices/quarkus-jpa-example
docker run --rm -p 8080:8080 --name="quarkus-jpa-example-1.0.2" \
--mount type=bind,source=$PWD/src/main/resources/application-docker.yml,\
target=/work/config/application.yml \
-it releases/de/ochmanski/microservices/quarkus-jpa-example:1.0.2
```

#### 7.1.1. Sample `application-docker.yml` with a password

```yaml
info:
  application:
    mounted: yes
quarkus:
  datasource:
    jdbc:
      url: mysql://host.docker.internal:3306/oss_module-a?serverTimezone=UTC&useLegacyDatetimeCode=false
    password: <changeme>
  http:
    cors: true
    port: 8080
  swagger-ui:
    always-include: true
    path: '/swagger-ui.html'
  log:
    level: DEBUG
```

### 7.2. how to run Quarkus from docker container with custom `application.yml` mount and a password

Sometimes, you may want to re-use your local `QUARKUS_DATASOURCE_PASSWORD`. If the value of the variable is already set,
you may pass the value directly into the docker container using `-e` flag. In such case, you can remove the password
from `application-docker.yml` file.

```bash
cd $AWS/de/ochmanski/microservices/quarkus-jpa-example
docker run -it --rm -p 8080:8080 --name="quarkus-jpa-example-1.0.2" \
--mount type=bind,source=$PWD/src/main/resources/application-docker.yml,\
target=/work/config/application.yml \
-e QUARKUS_DATASOURCE_PASSWORD=$QUARKUS_DATASOURCE_PASSWORD \
releases/de/ochmanski/microservices/quarkus-jpa-example:1.0.2
```

#### 7.2.1. Sample `application-docker.yml` without a password

```yaml
info:
  application:
    mounted: yes
quarkus:
  datasource:
    jdbc:
      url:mysql://host.docker.internal:3306/iam_sso-iam?serverTimezone=UTC&useLegacyDatetimeCode=false
  http:
    cors: true
    port: 8080
  swagger-ui:
    always-include: true
    path: '/swagger-ui.html'
  log:
    level: DEBUG
```

### 7.3. how to run Quarkus from docker container without mounting `application.yml`

```bash
docker run --rm -p 8080:8080 --name="quarkus-jpa-example-1.0.2" \
-e QUARKUS_DATASOURCE_PASSWORD=$QUARKUS_DATASOURCE_PASSWORD \
-it releases/de/ochmanski/microservices/quarkus-jpa-example:1.0.2
```

> **_NOTE:_** `quarkus.datasource.url` must contain: `jdbc:mysql://host.docker.internal:3306`
> not `jdbc:mysql://localhost:3306` !  
> because docker container doesn't connect to your localhost network, the way `gradle quarkusDev` does.  
> In a docker container `localhost` is not resolved to `127.0.0.1` of your physical machine.

### 7.4. how to build your own docker image

This is not recommended, but in case you are a DevOp, and you want to open the docker image, and debug it, before
publishing a final RELEASE, you may create a SNAPSHOT of the image locally, with the following command:

```bash
gradle jibDockerBuild
```

Please note, that the same snapshot will be automatically created by CodeBuild pipeline, so there is no need to create
it locally, you may simply push the commit into the remote git repository and create the image direcly in the CodeBuild
pipeline. The result will be the same.

#### 7.4.1. how to run a snapshot

look at the output of the gradle command in the console. Assuming that the created docker image is identified as:
`1.0.2-SNAPSHOT`, you may run it in the following manner:

```bash
cd $AWS/de/ochmanski/microservices/quarkus-jpa-example
docker run --rm -p 8080:8080 --name="quarkus-jpa-example-1.0.2-SNAPSHOT" \
--mount type=bind,source=$PWD/src/main/resources/application-docker.yml,\
target=/work/config/application.yml \
-it snapshots/de/ochmanski/microservices/quarkus-jpa-example:1.0.2-SNAPSHOT
```

> **_NOTE:_** `quarkus.datasource.url` must contain: `jdbc:mysql://host.docker.internal:3306`
> not `jdbc:mysql://localhost:3306` !  
> because docker container doesn't connect to your localhost network, the way `gradle quarkusDev` does.  
> In a docker container `localhost` is not resolved to `127.0.0.1` of your physical machine.

#### 7.4.2. how to open a docker image

look at the output of the gradle command in the console. Assuming that the created docker image is identified as:
`1.0.2-SNAPSHOT`, you may open it in the following manner:

```bash
cd $AWS/de/ochmanski/microservices/quarkus-jpa-example
docker run --rm -ti --privileged --entrypoint /bin/sh --rm -p 8080:8080 --name="quarkus-jpa-example-1.0.2-SNAPSHOT" \
--mount type=bind,source=$PWD/src/main/resources/application-docker.yml,\
target=/work/config/application.yml \
-it snapshots/de/ochmanski/microservices/quarkus-jpa-example:1.0.2-SNAPSHOT
```

#### 7.4.3. Sample `application-docker.yml` with a password

```yaml
info:
  application:
    mounted: yes
quarkus:
  datasource:
    jdbc:
      url:mysql://host.docker.internal:3306/iam_sso-iam?serverTimezone=UTC&useLegacyDatetimeCode=false
    password: <changeme>
  http:
    cors: true
    port: 8080
  swagger-ui:
    always-include: true
    path: '/swagger-ui.html'
  log:
    level: DEBUG
```

## 8. How to bump a version?

### 8.1. Add a new tag

```bash
git bump
```

or, standard way:

```bash
git checkout main
git tag -a 1.0.0 -m 'please always add -a flag, which is short for "annotated"'
git push --follow-tags
```
## 9. Related Guides

- Hibernate Validator ([guide](https://quarkus.io/guides/validation)): Validate object properties (field, getter) and
  method parameters for your beans (REST, CDI, JPA)

## 10. Including resources

Supporting native in your application
GraalVM imposes a number of constraints and making your application a native executable might require a few tweaks.

### 10.1. Including resources

https://quarkus.io/guides/writing-native-applications-tips#including-resources
https://quarkus.io/guides/writing-native-applications-tips#including-resources-2

```properties
quarkus.native.resources.includes=foo/**,bar/**/*.txt
```
