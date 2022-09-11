package de.ochmanski.microservices.oss.module_a.module_a_service_rest.api;

/**
 * The exception that can be used to store the HTTP status code returned by an API response.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class ApiException extends Exception {

    /**
     * The HTTP status code.
     */
    private int code;

    /**
     * Constructor.
     *
     * @param code The HTTP status code.
     * @param msg  The error message.
     */
    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    /**
     * Get the HTTP status code.
     *
     * @return The HTTP status code.
     */
    public int getCode() {
        return code;
    }

}
