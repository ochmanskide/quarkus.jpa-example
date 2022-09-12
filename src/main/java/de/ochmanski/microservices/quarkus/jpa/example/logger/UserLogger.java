package de.ochmanski.microservices.quarkus.jpa.example.logger;

import de.ochmanski.generated.model.UserSyncRequest;
import de.ochmanski.microservices.quarkus.jpa.example.mapper.UserResponseMapper;
import de.ochmanski.microservices.quarkus.jpa.example.rest.response.UserResponse;
import lombok.extern.log4j.Log4j2;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Log4j2
@ApplicationScoped
public class UserLogger {

    @Inject
    JacksonMapper jacksonMapper;

    @Inject
    UserResponseMapper userResponseMapper;

    private static final String SERVICE_NAME = "MCIP_SERVICE ";

    public Response log(UserSyncRequest userSyncRequest) {
        log.info(SERVICE_NAME + "POST /v1/user request: " + toJson(userSyncRequest));
        UserResponse user = userResponseMapper.mapUser(userSyncRequest);
        log.debug(SERVICE_NAME + "POST /v1/user response: " + toJson(user));
        return Response.ok(user).build();
    }

    private String toJson(UserSyncRequest userSyncRequest) {
        return jacksonMapper.toJson(userSyncRequest);
    }

    private String toJson(UserResponse userResponse) {
        return jacksonMapper.toJson(userResponse);
    }
}
