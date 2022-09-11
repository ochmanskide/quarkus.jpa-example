package de.ochmanski.microservices.quarkus.jpa.example.util;


import lombok.experimental.UtilityClass;

import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.TimeZone;

@UtilityClass
public class Constants {

    public final String MISSING_DB_ENTRY_APPENDER = "missingDBEntry_Appender";
    public final String APPLICATION_PROPERTIES = "application.properties";
    public final String APPLICATION_YML = "application.yml";
    public final String GIT_PROPERTIES = "pre-tag-git.properties";
    public final String GRADLE_PROPERTIES = "gradle.properties";
    public final String BUILD_PROPERTIES = "build.properties";
    public final String BUILD_NUMBER_PROPERTIES = "buildNumber.properties";
    public final String JIB_ENV_PROPERTIES = "jibEnv.properties";
    public final String JVM_ARGS_PROPERTIES = "jvmArgs.properties";
    public final String BUILD_START_TIME_PROPERTIES = "buildStartTime.properties";
    public final String DOCKER_YAML = "/work/config/application.yml";
    public final String QUARKUS_RUNTIME_CONFIG_DEFAULTS = "quarkus-runtime-config-defaults.properties";
    public final String MESSAGES_PROPERTIES = "messages.properties";
    public final String MESSAGES_DE_PROPERTIES = MESSAGES_PROPERTIES + "_de.properties";
    public final String MESSAGES_EN_PROPERTIES = MESSAGES_PROPERTIES + "_en.properties";
    public final String ERROR_MESSAGES = "ErrorMessages";
    public final String ERROR_MESSAGES_DE_PROPERTIES = ERROR_MESSAGES + "_de.properties";
    public final String ERROR_MESSAGES_EN_PROPERTIES = ERROR_MESSAGES + "_en.properties";
    public final String VALIDATION_MESSAGES = "ValidationMessages";
    public final String VALIDATION_MESSAGES_DE = VALIDATION_MESSAGES + "_de";
    public final String VALIDATION_MESSAGES_EN = VALIDATION_MESSAGES + "_en";
    public final String VALIDATION_MESSAGES_DE_PROPERTIES = VALIDATION_MESSAGES + "_de.properties";
    public final String VALIDATION_MESSAGES_EN_PROPERTIES = VALIDATION_MESSAGES + "_en.properties";
    public final String JAXRS_RESTEASY = "org.openapitools.codegen.languages.JavaResteasyServerCodegen";
    public final String CHARSET_UTF = ";charset=UTF-8";
    public final String MEDIA_TYPE_WITH_CHARSET = MediaType.APPLICATION_JSON + CHARSET_UTF;
    public final String HTML_WITH_CHARSET = MediaType.TEXT_HTML + CHARSET_UTF;
    public final String BLANK = "";
    public final String SPACE_CHARACTER = " ";
    public final String UNDEFINED = "undefined";
    public final String EUR = "EUR";
    public final String NBSP = "&nbsp";
    public final String BR = "<br/>\n\n";
    public final String BR_BR = BR + BR;
    public final String OPEN_SEARCH_URL = "https://logs-tmp.id-tool.blueid.net";

    @UtilityClass
    public class REST {
        public final String DATE_FORMAT = "yyyy-MM-dd";
        public final String TIME_FORMAT = "HH:mm:ss";
        public final String YEAR = "" + 2022;
    }

    /**
     * Current year as small int
     */
    public final int YEAR = LocalDate.now().getYear();
    public final String DEFAULT_TIMEZONE = "UTC";
    public final TimeZone UTC = TimeZone.getTimeZone(Constants.DEFAULT_TIMEZONE);

    @UtilityClass
    public class RFC3986 {

        /**
         * V1
         */
        public final String API_VERSION = "V1";

        /**
         * v1
         */
        public final String API_VERSION_LOWERCASE = API_VERSION.toLowerCase();

        /**
         * mcip-database-template
         */
        public final String APPLICATION_NAME = "MCIP database template";

        /**
         * MDT - MCIP database template
         */
        public final String ERROR_CODE_PREFIX = "MDT";

        /**
         * mcip-database-template
         */
        public final String ARTIFACT_ID = "mcip-database-template";

        /**
         * mcip_database_template
         */
        public final String ARTIFACT_ID_SNAKE_CASE = ARTIFACT_ID.replace("-", "_");

        /**
         * net.blueid.microservices.mcip
         */
        public final String GROUP_ID = "net.blueid.microservices.mcip";

        /**
         * net_blueid_microservices_mcip
         */
        public final String GROUP_ID_SNAKE_CASE = GROUP_ID.replace(".", "_");

        /**
         * net-blueid-microservices-mcip
         */
        public final String GROUP_ID_KEBAB_CASE = GROUP_ID.replace(".", "-");

        /**
         * net/blueid/microservices/mcip
         */
        public final String GROUP_ID_PATH = GROUP_ID.replace(".", "/");

        /**
         * mcip-database-template-v1
         */
        public final String DNS_NAME = ARTIFACT_ID + "-" + API_VERSION_LOWERCASE;
    }
}
