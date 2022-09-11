package de.ochmanski.microservices.quarkus.jpa.example.controller;

import de.ochmanski.microservices.quarkus.jpa.example.util.ApplicationPropertiesConfig;
import de.ochmanski.microservices.quarkus.jpa.example.util.Constants;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.ParameterizedMessageFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log4j2
@Path("/")
public class HelloController {

    @Inject
    ApplicationPropertiesConfig applicationPropertiesConfig;

    @PostConstruct
    void started() {
        TimeZone.setDefault(UTC);
    }

    @Path("/")
    @GET
    @Produces({MediaType.TEXT_HTML})
    public String index() {
        return "<h1 style=\"text-align: center;\">Swagger Documentation:</h1><br/>\n" +
                getAbsoluteHyperlink() +

                getQuarkusDevMode() +

                "<h3>Environment:</h3>" +
                "Amazon account: " + applicationPropertiesConfig.getAmazonAccount() + BR +
                "Environment: " + applicationPropertiesConfig.getReleaseEnv() + BR +
                "EC2 Task Definition Revision: " + applicationPropertiesConfig.getEc2TaskDefinitionRevision() + BR +
                "IaC Build Number: " + applicationPropertiesConfig.getIacCodeBuildNumber() + BR_BR +

                "<h3>General:</h3>" +
                "Quarkus Application name: " + applicationPropertiesConfig.getApplicationName() + BR +
                "API version: " + Constants.RFC3986.API_VERSION + BR +
                "Application Description: " + applicationPropertiesConfig.getApplicationDescription() + BR +
                "Application Version: " + applicationPropertiesConfig.getApplicationVersion() + BR +
                "Info Application Description: " + applicationPropertiesConfig.getInfoApplicationDescription() + BR +
                "mounted: " + applicationPropertiesConfig.getInfoApplicationMounted() + BR_BR +

                "<h3>Logs:</h3>" +
                "<a href=\"" + OPEN_SEARCH_URL + "/_dashboards/app/discover" +
                "#/?_g=(filters:!(),refreshInterval:(pause:!t,value:0)," +
                "time:(from:now%2Fd,to:now%2Fd))&_a=(columns:!(message)," +
                "filters:!(('$state':(store:appState),meta:(alias:!n," +
                "disabled:!f,index:c35c4440-f7e8-11ec-aae2-192400618207," +
                "key:logGroup,negate:!f,params:(query:" + Constants.RFC3986.DNS_NAME + "),type:phrase)," +
                "query:(match_phrase:(logGroup:" + Constants.RFC3986.DNS_NAME + "))))," +
                "index:c35c4440-f7e8-11ec-aae2-192400618207,interval:auto," +
                "query:(language:kuery,query:''),savedQuery:" + Constants.RFC3986.DNS_NAME + ",sort:!())\">" +
                OPEN_SEARCH_URL + "</a>" + BR_BR +

                "<h3>CodeCommit:</h3>" +
                "<a href=\"https://eu-central-1.console.aws.amazon.com/codesuite/codecommit/repositories/" +
                Constants.RFC3986.GROUP_ID + "." + Constants.RFC3986.ARTIFACT_ID + "/browse?region=eu-central-1\">" +
                "Git Repository</a><br/><br/>\n" +
                "Git clone command:<br/>" +
                "<pre>git clone codecommit::eu-central-1://Blueid-id-developer@"
                + Constants.RFC3986.GROUP_ID + "." + Constants.RFC3986.ARTIFACT_ID + " " +
                "~/Workspace/aws/" + Constants.RFC3986.GROUP_ID_PATH + "/" + Constants.RFC3986.ARTIFACT_ID
                + "</pre>" + BR_BR +

                "<h3>CodeBuild:</h3>" +
                "ID: " + Constants.RFC3986.GROUP_ID_KEBAB_CASE + "-" + Constants.RFC3986.ARTIFACT_ID +
                "-build-project" + BR +
                "URL: https://eu-central-1.console.aws.amazon.com/codesuite/codebuild/964010022385/projects/" +
                Constants.RFC3986.GROUP_ID_KEBAB_CASE + "-" + Constants.RFC3986.ARTIFACT_ID + "-build-project" + BR +
                "<a href=\"https://eu-central-1.console.aws.amazon.com/codesuite/codebuild/964010022385/projects/" +
                Constants.RFC3986.GROUP_ID_KEBAB_CASE + "-" + Constants.RFC3986.ARTIFACT_ID + "-build-project/details" +
                "?region=eu-central-1\">Build details</a>" + BR +
                "<a href=\"https://eu-central-1.console.aws.amazon.com/codesuite/codebuild/964010022385/projects/" +
                Constants.RFC3986.GROUP_ID_KEBAB_CASE + "-" + Constants.RFC3986.ARTIFACT_ID + "-build-project/history" +
                "?region=eu-central-1\">Build history</a>" + BR +
                "Build number: " + getBuildNumber() + BR_BR +

                getJvmProperties() +

                getGradleProperties() +

                getGitPropertiesFromNativeImage() +

                getApplicationYmlFromNativeImage() +

                getAdditionalProjectProperties() +

                getBuildNumberFromNativeImage() +

                getBuildPropertiesFromNativeImage() +

                getJibEnvPropertiesFromNativeImage() +

                getJvmArgsPropertiesFromNativeImage() +

                getBuildStartTimePropertiesFromNativeImage() +

                getGradlePropertiesFromNativeImage() +

                getQuarkusRuntimeConfigDefaults() +

                getCurrentThreadResources() +

                getCurrentClassloaderResources() +

                getCurrentClassloaderResourcesFromReflection() +

                getGitProperties() +

                //getDataSourceProperties() +

                getProjectProperties() +

                getEnvironmentVariables() +

                getSystemProperties() +

                BR;
    }

    private String getGradleProperties() {
        return "<h3>Gradle:</h3>" +
                "Application name: " + applicationPropertiesConfig.getApplicationName() + BR +
                "Build artifact: " + applicationPropertiesConfig.getApplicationArtifactId() + BR +
                "Build group: " + applicationPropertiesConfig.getApplicationGroupId() + BR +
                "Build time: " + getBuildTime() + BR +
                "Build uuid: " + applicationPropertiesConfig.getUuid() + BR +
                "Build version: " + applicationPropertiesConfig.getApplicationVersion() + BR_BR;
    }

    private String getGradlePropertiesFromNativeImage() {
        return "<h3>" + GRADLE_PROPERTIES + " from native image:</h3>" +
                getNativeResource("/" + GRADLE_PROPERTIES) +
                BR_BR;
    }

    private String getBuildPropertiesFromNativeImage() {
        return "<h3>Build time environment variables:</h3>" +
                "<h3>" + BUILD_PROPERTIES + " from native image:</h3>" +
                getNativeResource("/" + BUILD_PROPERTIES) +
                BR_BR;
    }

    private String getJibEnvPropertiesFromNativeImage() {
        return "<h3>" + JIB_ENV_PROPERTIES + " from native image:</h3>" +
                getNativeResource("/" + JIB_ENV_PROPERTIES) +
                BR_BR;
    }

    private String getJvmArgsPropertiesFromNativeImage() {
        return "<h3>" + JVM_ARGS_PROPERTIES + " from native image:</h3>" +
                getNativeResource("/" + JVM_ARGS_PROPERTIES) +
                BR_BR;
    }

    private String getBuildStartTimePropertiesFromNativeImage() {
        return "<h3>" + BUILD_START_TIME_PROPERTIES + " from native image:</h3>" +
                getNativeResource("/" + BUILD_START_TIME_PROPERTIES) +
                BR_BR;
    }

    private String getGitPropertiesFromNativeImage() {
        return "<h3>Git</h3>" +
                "<h3>git.properties from native image:</h3>" +
                getNativeResource("/" + GIT_PROPERTIES) +
                BR_BR;
    }

    private String getApplicationYmlFromNativeImage() {
        return "<h3>Resources</h3>" +
                "<h3>" + APPLICATION_YML + " from native image:</h3>" +
                getNativeResource("/" + APPLICATION_YML) +
                BR_BR;
    }

    private String getBuildNumberFromNativeImage() {
        return "<h3>" + BUILD_NUMBER_PROPERTIES + " from native image:</h3>" +
                getNativeResource("/" + BUILD_NUMBER_PROPERTIES) +
                BR_BR;
    }

    private String getQuarkusRuntimeConfigDefaults() {
        return "<h3>" + QUARKUS_RUNTIME_CONFIG_DEFAULTS + " from native image:</h3>" +
                getNativeResource("/" + QUARKUS_RUNTIME_CONFIG_DEFAULTS) +
                BR_BR;
    }

    private String getNativeResource(String resource) {
        try {
            List<String> lines = new LinkedList<>();
            Scanner s = new Scanner(new BufferedReader(new InputStreamReader(getResourceAsStream(resource))));
            while (s.hasNextLine()) {
                lines.add(s.nextLine());
            }
            return prettyPrint(lines);
        } catch (FileSystemNotFoundException | NullPointerException e) {
            try {
                return "Could not load " + resource;
            } catch (Exception ex) {
                // Error Code BSM009
                return logWarning(9, "Could not load {}", resource, ex);
            }
        }
    }

    @Nullable
    private InputStream getResourceAsStream(String resource) {
        return this.getClass().getResourceAsStream(resource);
    }

    private String prettyPrint(List<String> lines) {
        return lines.stream()
                .map(s -> s.replace(SPACE_CHARACTER, NBSP))
                .collect(Collectors.joining(BR));
    }

    private String getCurrentThreadResources() {
        try {
            List<String> resources = new LinkedList<>();
            Iterator<URL> it = Thread.currentThread().getContextClassLoader().getResources(BLANK).asIterator();
            while (it.hasNext()) {
                URL u = it.next();
                resources.add(u.getFile());
            }
            return "<h3>Resources:</h3>" +
                    (resources.isEmpty() ? "Could not find resources." : resources.stream()
                            .map(s -> s.replace(SPACE_CHARACTER, NBSP))
                            .collect(Collectors.joining(BR))) + BR_BR;
        } catch (IOException e) {
            // Error Code BSM002
            logWarning(2, "Could not find resources.", e);
            return "<h3>Resources:</h3>Could not find resources." + BR_BR;
        }
    }

    private String getCurrentClassloaderResources() {
        try {
            String resources = findResources()
                    .map(java.nio.file.Path::toAbsolutePath)
                    .map(java.nio.file.Path::toString)
                    .map(s -> s.replace(SPACE_CHARACTER, NBSP))
                    .collect(Collectors.joining(BR));
            return "<h3>Resources from new I/O:</h3>" +
                    (resources.isBlank() ? "Could not find resources." : resources) + BR_BR;
        } catch (Exception e) {
            // Error Code BSM003
            logWarning(3, "Could not find resources.", e);
            return "<h3>Resources from new I/O:</h3>Could not find resources." + BR_BR;
        }
    }

    public Stream<java.nio.file.Path> findResources() {
        URI uri = null;
        try {
            uri = HelloController.class.getClassLoader().getResource("").toURI();
        } catch (URISyntaxException | NullPointerException e) {
            // Error Code BSM004
            logWarning(4, "Resources directory /resources not found.", e);
        }
        try {
            if (uri.getScheme().equals("jar")) {
                try (FileSystem fileSystem = FileSystems.newFileSystem(uri, Collections.emptyMap())) {
                    return Files.walk(fileSystem.getPath(""), 1);
                }
            } else {
                return Files.walk(Paths.get(uri), 1);
            }
        } catch (IOException | NullPointerException e) {
            // Error Code BSM005
            logWarning(5, "Resources directory /resources not found.", e);
        }
        return Stream.empty();
    }

    private String getCurrentClassloaderResourcesFromReflection() {
        try {
            String resources = findResourcesFromReflection().stream()
                    .map(s -> s.replace(SPACE_CHARACTER, NBSP))
                    .collect(Collectors.joining(BR));
            return "<h3>Resources from Reflection:</h3>" +
                    (resources.isBlank() ? "Could not find resources." : resources) + BR_BR;
        } catch (Exception e) {
            // Error Code BSM007
            logWarning(7, "Could not find resources.", e);
            return "<h3>Resources from Reflection:</h3>Could not find resources." + BR_BR;
        }
    }

    public Set<String> findResourcesFromReflection() {
        try {
            return getCollectionOfResources();
        } catch (Exception e) {
            // Error Code BSM008
            logWarning(8, "Resources directory /resources not found.", e);
        }
        return Set.of();
    }

    private Set<String> getCollectionOfResources() {
        List<?> list = getListOfElements();
        return list.stream()
                .filter(p -> !"io.quarkus.bootstrap.classloading.MemoryClassPathElement".equals(p.getClass().getName()))
                .flatMap(this::getResourcesField)
                .filter(p -> !p.endsWith(".class"))
                .filter(p -> p.endsWith(".properties") || p.endsWith("ml") || p.endsWith(".json"))
                .collect(Collectors.toUnmodifiableSet());
    }

    private Stream<String> getResourcesField(Object memoryClassPathElement) {
        try {
            Field field = memoryClassPathElement.getClass().getDeclaredField("resources");
            field.setAccessible(true);
            return getFieldValue(memoryClassPathElement, field);
        } catch (NoSuchFieldException e) {
            log.debug("getResourcesField() failed, no such field: resources", e);
            return Stream.empty();
        }
    }

    private Stream<String> getFieldValue(Object memoryClassPathElement, Field field) {
        try {
            @SuppressWarnings("unchecked") Set<String> set = (Set<String>) field.get(memoryClassPathElement);
            return set.stream();
        } catch (IllegalAccessException e) {
            log.debug("field.get(memoryClassPathElement) in getFieldValue() failed,", e);
            return Stream.empty();
        } catch (ClassCastException e) {
            log.debug("cannot cast (Set) field.get(memoryClassPathElement)", e);
            return Stream.empty();
        }
    }

    private List<?> getListOfElements() {
        ClassLoader classLoader = HelloController.class.getClassLoader();
        try {
            Field field = classLoader.getClass().getDeclaredField("elements");
            field.setAccessible(true);
            return getFieldValue(classLoader, field);
        } catch (NoSuchFieldException e) {
            log.debug("getListOfElements() failed,", e);
            return List.of();
        }
    }

    private List<?> getFieldValue(ClassLoader classLoader, Field field) {
        try {
            return (List<?>) field.get(classLoader);
        } catch (IllegalAccessException e) {
            log.debug("field.get(classLoader) in getListOfElements() failed,", e);
            return List.of();
        } catch (ClassCastException e) {
            log.debug("cannot cast (List) field.get(classLoader)", e);
            return List.of();
        }
    }

    private String getBuildTime() {
        String buildTime = System.getenv("CODEBUILD_BUILD_TIME");
        return null == buildTime || buildTime.isBlank() ?
                Constants.UNDEFINED : buildTime;
    }

    private String getBuildNumber() {
        String buildNumber = System.getenv("CODEBUILD_BUILD_NUMBER");
        return null == buildNumber || buildNumber.isBlank() ?
                Constants.UNDEFINED : buildNumber;
    }

    private String getGitProperties() {
        return "<h3>" + GIT_PROPERTIES + " loaded into Quarkus:</h3>" +
                getResource(GIT_PROPERTIES) + BR_BR;
    }

//    @PersistenceContext
//    EntityManager entityManager;

//    public HikariDataSource getDataSourceFromHibernateEntityManager() {
//        EntityManagerFactoryInfo info = (EntityManagerFactoryInfo) entityManager.getEntityManagerFactory();
//        return (HikariDataSource) info.getDataSource();
//    }
//
//    private String getDataSourceProperties() {
//        HikariDataSource dataSource = getDataSourceFromHibernateEntityManager();
//        return "<h3>DataSource properties:</h3>" +
//                "Username: " + dataSource.getUsername() + "" + BR +
//                "URL: " + dataSource.getJdbcUrl() + "" + BR +
//                "Driver Class Name: " + dataSource.getDriverClassName() + BR_BR;
//    }

    private String getQuarkusDevMode() {
        return "<a href=\"dev\">" +
                "<div style=\"text-align: center; font-size: 40px;\">Quarkus Dev Console</div>" +
                "</a>" + BR_BR;
    }

    private String getAbsoluteHyperlink() {
        return "<a href=\"swagger-ui.html\">" +
                "<div style=\"text-align: center; font-size: 40px;\">https://" +
                Constants.RFC3986.DNS_NAME +
                "." + applicationPropertiesConfig.getAmazonAccount() +
                ".blueid.net/swagger-ui.html</div>" +
                "</a>" + BR_BR;
    }

    private String getJvmProperties() {
        return "<h3>JVM:</h3>" +
                "current time: " + ZonedDateTime.now() + BR +
                "default timezone: " + ZoneId.systemDefault() + BR +
                "start time: " + getStartTime() + BR +
                "up time: " + getUpTime() + BR_BR;
    }

    private ZonedDateTime getStartTime() {
        long startTime = ManagementFactory.getRuntimeMXBean().getStartTime();
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(startTime),
                TimeZone.getDefault().toZoneId());
    }

    private String getUpTime() {
        long uptime = ManagementFactory.getRuntimeMXBean().getUptime();
        return DurationFormatUtils.formatDuration(uptime,
                "d 'days' H 'hours' m 'minutes' s.SSS 'seconds'",
                true);
    }

    private String getProjectProperties() {
        return "<h3>" + APPLICATION_YML + " from java.nio.file.Files:</h3>" +
                getResource(APPLICATION_YML) + BR_BR;
    }

    private String getAdditionalProjectProperties() {
        return "<h3>" + Constants.DOCKER_YAML + ":</h3>" +
                getResourceAbsolute(Constants.DOCKER_YAML) + BR_BR;
    }

    private String getResource(String resource) {
        try {
            return prettyPrint(resource);
        } catch (FileSystemNotFoundException | IOException | URISyntaxException | NullPointerException e) {
            try {
                return GIT_PROPERTIES.equalsIgnoreCase(resource)
                        ? getGitPropertiesFromFields()
                        : "Could not load " + resource;
            } catch (Exception ex) {
                // Error Code BSM009
                return logWarning(9, "Could not load {}", resource, ex);
            }
        }
    }

    private String getResourceAbsolute(String resource) {
        try {
            return prettyPrintFile(resource);
        } catch (FileSystemNotFoundException | IOException | URISyntaxException | NullPointerException e) {
            // Error Code BSM010
            return logError(10, "Could not load {}", resource, e);
        }
    }

    private String getGitPropertiesFromFields() {
        return "git.branch: " + applicationPropertiesConfig.getGitBranch() + BR +
                "git.build.host: " + applicationPropertiesConfig.getGitBuildHost() + BR +
                "git.build.user.email: " + applicationPropertiesConfig.getGitBuildUserEmail() + BR +
                "git.build.user.name: " + applicationPropertiesConfig.getGitBuildUserName() + BR +
                "git.build.version: " + applicationPropertiesConfig.getGitBuildVersion() + BR +
                "git.closest.tag.commit.count: " + applicationPropertiesConfig.getGitClosestTagCommitCount() + BR +
                "git.closest.tag.name: " + applicationPropertiesConfig.getGitClosesTagName() + BR +
                "git.commit.id: " + applicationPropertiesConfig.getGitCommitId() + BR +
                "git.commit.id.abbrev: " + applicationPropertiesConfig.getGitCommitIdAbbrev() + BR +
                "git.commit.id.describe: " + applicationPropertiesConfig.getGitCommitIdDescribe() + BR +
                "git.commit.message.full: " + applicationPropertiesConfig.getGitCommitMessageFull() + BR +
                "git.commit.message.short: " + applicationPropertiesConfig.getGitCommitMessageShort() + BR +
                "git.commit.time: " + applicationPropertiesConfig.getGitCommitTime() + BR +
                "git.commit.user.email: " + applicationPropertiesConfig.getGitCommitUserEmail() + BR +
                "git.commit.user.name: " + applicationPropertiesConfig.getGitCommitUserName() + BR +
                "git.dirty: " + applicationPropertiesConfig.getGitDirty() + BR +
                "git.remote.origin.url: " + applicationPropertiesConfig.getGitRemoteOriginUrl() + BR +
                "git.tags: " + applicationPropertiesConfig.getGitTags() + BR +
                "git.total.commit.count: " + applicationPropertiesConfig.getGitTotalCommitCount() + BR_BR;
    }

    private String prettyPrintFile(String resource) throws IOException, URISyntaxException {
        log.debug("HelloController::prettyPrintFile String resource: {}", resource);
        listFiles(1, resource);
        listFiles(2, "/");
        listFiles(3, "/work/");
        listFiles(4, "/work/config/");
        listFiles(5, ".");
        listFiles(6, "./");
        listFiles(7, "../");
        listFiles(8, "../../");
        listFiles(9, "../../../");
        listFiles(10, "../../../resources/");
        listFiles(11, "../../../resources/main/");
        return Files.readAllLines(Paths.get(resource)).stream()
                .map(s -> s.replace(SPACE_CHARACTER, NBSP))
                .collect(Collectors.joining(BR));
    }

    private void listFiles(int index, String resource) {
        log.debug("\n " + index + "Path: {}", resource);
        try {
            java.nio.file.Path dir = Paths.get(resource);
            if (Files.isDirectory(dir)) {
                Files.list(dir).forEach(p -> log.debug("File: {}", p));
            } else {
                Files.readAllLines(dir).forEach(log::debug);
            }
        } catch (IOException e) {
            // Error Code BSM006
            logWarning(6, "Could not list files in resource {}", resource, e);
        }
    }

    private String prettyPrint(String resource) throws IOException, URISyntaxException {
        return Files.readAllLines(getPath(resource)).stream()
                .map(s -> s.replace(SPACE_CHARACTER, NBSP))
                .collect(Collectors.joining(BR));
    }

    private java.nio.file.Path getPath(String resource) throws URISyntaxException, FileSystemNotFoundException {
        return Paths.get(this.getClass().getClassLoader().getResource(resource).toURI());
    }

    private String getEnvironmentVariables() {
        return applicationPropertiesConfig.hideEnvironmentVariables()
                ? Constants.BLANK
                : getEnvironmenVariablesUnsafe();
    }

    private String getEnvironmenVariablesUnsafe() {
        Map<String, String> prop = System.getenv();
        return "<h3>Runtime environment variables:</h3>" +
                prop.entrySet().stream()
                        .map(this::maskSensitiveInfo)
                        .map(p -> p.getKey() + ": " + p.getValue())
                        .collect(Collectors.joining(BR))
                + BR_BR;
    }

    private Map.Entry<String, String> maskSensitiveInfo2(Map.Entry<Object, Object> entry) {
        try {
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            Map.Entry<String, String> newEntry = Map.entry(key, value);
            return maskSensitiveInfo(newEntry);
        } catch (ClassCastException e) {
            // Error Code BSM012
            logWarning(12, "Cannot cast {}{}",
                    entry.getKey().toString(),
                    entry.getValue().toString(), e);
        }
        return Map.entry(entry.getKey().toString(), entry.getValue().toString());
    }

    private Map.Entry<String, String> maskSensitiveInfo(Map.Entry<String, String> entry) {
        if ("SPRING_DATASOURCE_PASSWORD".equalsIgnoreCase(entry.getKey())) {
            return mask(entry);
        }
        if ("QUARKUS_DATASOURCE_PASSWORD".equalsIgnoreCase(entry.getKey())) {
            return mask(entry);
        }
        return entry;
    }

    private Map.Entry<String, String> mask(Map.Entry<String, String> entry) {
        return Map.entry(entry.getKey(), "*****");
    }

    private String getSystemProperties() {
        Properties prop = System.getProperties();
        return "<h3>Runtime system properties:</h3>" +
                prop.entrySet().stream()
                        .map(this::maskSensitiveInfo2)
                        .map(p -> p.getKey() + ": " + p.getValue())
                        .collect(Collectors.joining(BR))
                + BR_BR;
    }

    private String logWarning(int errorCode, String message, Exception e) {
        String normalizedErrorCode = leftPad(errorCode);
        ParameterizedMessageFactory messageFactory = createMessageFactory();
        String messageWithErrorCode = createMessageWithErrorCode(message);
        Message m = messageFactory.newMessage(messageWithErrorCode, ERROR_CODE_PREFIX, normalizedErrorCode);
        log.warn(m);
        log.debug(m, e);
        return m.getFormattedMessage();
    }

    private String logWarning(int errorCode, String message, String param1, Exception e) {
        String normalizedErrorCode = leftPad(errorCode);
        ParameterizedMessageFactory messageFactory = createMessageFactory();
        String messageWithErrorCode = createMessageWithErrorCode(message);
        Message m = messageFactory.newMessage(messageWithErrorCode, ERROR_CODE_PREFIX, normalizedErrorCode, param1);
        log.warn(m);
        log.debug(m, e);
        return m.getFormattedMessage();
    }

    private String logWarning(int errorCode, String message, String param1, String param2, Exception e) {
        String normalizedErrorCode = leftPad(errorCode);
        ParameterizedMessageFactory messageFactory = createMessageFactory();
        String messageWithErrorCode = createMessageWithErrorCode(message);
        Message m = messageFactory.newMessage(messageWithErrorCode, ERROR_CODE_PREFIX, normalizedErrorCode, param1, param2);
        log.warn(m);
        log.debug(m, e);
        return m.getFormattedMessage();
    }

    private String logError(int errorCode, String message, Exception e) {
        String normalizedErrorCode = leftPad(errorCode);
        ParameterizedMessageFactory messageFactory = createMessageFactory();
        String messageWithErrorCode = createMessageWithErrorCode(message);
        Message m = messageFactory.newMessage(messageWithErrorCode, ERROR_CODE_PREFIX, normalizedErrorCode);
        log.error(m);
        log.debug(m, e);
        return m.getFormattedMessage();
    }

    private String logError(int errorCode, String message, String param1, Exception e) {
        String normalizedErrorCode = leftPad(errorCode);
        ParameterizedMessageFactory messageFactory = createMessageFactory();
        String messageWithErrorCode = createMessageWithErrorCode(message);
        Message m = messageFactory.newMessage(messageWithErrorCode, ERROR_CODE_PREFIX, normalizedErrorCode, param1);
        log.error(m);
        log.debug(m, e);
        return m.getFormattedMessage();
    }

    @NotNull
    private ParameterizedMessageFactory createMessageFactory() {
        return ParameterizedMessageFactory.INSTANCE;
    }

    @NotNull
    private String createMessageWithErrorCode(String message) {
        return "Error Code {}{}: " + message;
    }

    public String leftPad(int errorCode) {
        return String.format("%03d", errorCode);
    }
}
