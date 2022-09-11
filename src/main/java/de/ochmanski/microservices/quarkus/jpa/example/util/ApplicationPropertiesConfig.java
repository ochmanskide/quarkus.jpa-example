package de.ochmanski.microservices.quarkus.jpa.example.util;


import lombok.Getter;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Getter
public class ApplicationPropertiesConfig {

    @ConfigProperty(name = "application-description", defaultValue = Constants.UNDEFINED)
    String applicationDescription;

    @ConfigProperty(name = "info.application.apiVersion", defaultValue = "1")
    String apiVersion;

//    @ConfigProperty(name="info.application.buildNumber")
//    String buildNumber;

    //@ConfigProperty(name="info.application.buildTime")
//    String buildTime;

    @ConfigProperty(name = "info.application.description", defaultValue = Constants.RFC3986.APPLICATION_NAME)
    String infoApplicationDescription;

    @ConfigProperty(name = "info.application.mounted", defaultValue = "no")
    String infoApplicationMounted;

    @ConfigProperty(name = "info.amazon.account", defaultValue = "local")
    String amazonAccount;

    @ConfigProperty(name = "release.env", defaultValue = "local")
    String releaseEnv;

    @ConfigProperty(name = "iac.code.build.number", defaultValue = Constants.UNDEFINED)
    String iacCodeBuildNumber;

    @ConfigProperty(name = "ec2.task.definition.revision", defaultValue = Constants.UNDEFINED)
    String ec2TaskDefinitionRevision;

    @ConfigProperty(name = "quarkus.application.name", defaultValue = Constants.RFC3986.APPLICATION_NAME)
    String applicationName;

    /**
     * https://quarkus.io/guides/all-config#quarkus-core_quarkus.platform.artifact-id
     */
    @ConfigProperty(name = "quarkus.platform.artifact-id", defaultValue = Constants.RFC3986.ARTIFACT_ID)
    String applicationArtifactId;

    /**
     * https://quarkus.io/guides/all-config#quarkus-core_quarkus.platform.group-id
     */
    @ConfigProperty(name = "quarkus.platform.group-id", defaultValue = Constants.RFC3986.GROUP_ID)
    String applicationGroupId;

    @ConfigProperty(name = "quarkus.application.version", defaultValue = "local-SNAPSHOT")
    String applicationVersion;

    @ConfigProperty(name = "show.environment.variables", defaultValue = "true")
    boolean showEnvironmentVariables;

    @ConfigProperty(name = "quarkus.uuid", defaultValue = Constants.UNDEFINED)
    String uuid;

    @ConfigProperty(name = "git.branch", defaultValue = Constants.UNDEFINED)
    String gitBranch;

    @ConfigProperty(name = "git.build.host", defaultValue = Constants.UNDEFINED)
    String gitBuildHost;

    @ConfigProperty(name = "git.build.user.email", defaultValue = Constants.UNDEFINED)
    String gitBuildUserEmail;

    @ConfigProperty(name = "git.build.user.name", defaultValue = Constants.UNDEFINED)
    String gitBuildUserName;

    @ConfigProperty(name = "git.build.version", defaultValue = Constants.UNDEFINED)
    String gitBuildVersion;

    @ConfigProperty(name = "git.closest.tag.commit.count", defaultValue = Constants.UNDEFINED)
    String gitClosestTagCommitCount;

    @ConfigProperty(name = "git.closest.tag.name", defaultValue = Constants.UNDEFINED)
    String gitClosesTagName;

    @ConfigProperty(name = "git.commit.id", defaultValue = Constants.UNDEFINED)
    String gitCommitId;

    @ConfigProperty(name = "git.commit.id.abbrev", defaultValue = Constants.UNDEFINED)
    String gitCommitIdAbbrev;

    @ConfigProperty(name = "git.commit.id.describe", defaultValue = Constants.UNDEFINED)
    String gitCommitIdDescribe;

    @ConfigProperty(name = "git.commit.message.full", defaultValue = Constants.UNDEFINED)
    String gitCommitMessageFull;

    @ConfigProperty(name = "git.commit.message.short", defaultValue = Constants.UNDEFINED)
    String gitCommitMessageShort;

    @ConfigProperty(name = "git.commit.time", defaultValue = Constants.UNDEFINED)
    String gitCommitTime;

    @ConfigProperty(name = "git.commit.user.email", defaultValue = Constants.UNDEFINED)
    String gitCommitUserEmail;

    @ConfigProperty(name = "git.commit.user.name", defaultValue = Constants.UNDEFINED)
    String gitCommitUserName;

    @ConfigProperty(name = "git.dirty", defaultValue = Constants.UNDEFINED)
    String gitDirty;

    @ConfigProperty(name = "git.remote.origin.url", defaultValue = Constants.UNDEFINED)
    String gitRemoteOriginUrl;

    @ConfigProperty(name = "git.tags", defaultValue = Constants.UNDEFINED)
    String gitTags;

    @ConfigProperty(name = "git.total.commit.count", defaultValue = Constants.UNDEFINED)
    String gitTotalCommitCount;

    public boolean hideEnvironmentVariables() {
        return !isShowEnvironmentVariables();
    }
}
