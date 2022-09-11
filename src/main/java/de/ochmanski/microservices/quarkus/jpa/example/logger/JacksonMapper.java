package de.ochmanski.microservices.quarkus.jpa.example.logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import de.ochmanski.microservices.quarkus.jpa.example.repository.OssMapIdentity;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JacksonMapper {

    @ConfigProperty(name = "de.ochmanski.microservices.oss.mcip.jackson.prettyPrint", defaultValue = "true")
    boolean prettyPrint;

    public String toJson(Object o) {
        return toJsonUnfiltered(o)
                .replace("class " + OssMapIdentity.class.getSimpleName() + " ", "");
    }

    private String toJsonUnfiltered(Object o) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, prettyPrint);
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            try {
                return null == o ? "null" : o.toString();
            } catch (Throwable t) {
                return "toString() methods has thrown exception with message: " + t.getMessage();
            }
        }
    }
}
