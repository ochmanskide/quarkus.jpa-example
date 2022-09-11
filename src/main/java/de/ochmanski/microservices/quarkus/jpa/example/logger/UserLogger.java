package de.ochmanski.microservices.quarkus.jpa.example.logger;

import de.ochmanski.generated.model.UserSyncRequest;
import de.ochmanski.microservices.quarkus.jpa.example.mapper.UserResponseMapper;
import de.ochmanski.microservices.quarkus.jpa.example.rest.response.OssMapIdentitySyncFromMcipResponse;
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
    UserResponseMapper mapIdentityServiceResponseMapper;

    private static final String SERVICE_NAME = "MCIP_SERVICE ";

    public Response insert(UserSyncRequest userSyncRequest) {
        log.info(SERVICE_NAME + "POST /v1/user request: " + toJson(userSyncRequest));
        OssMapIdentitySyncFromMcipResponse ossMapIdentitySyncFromMcipResponse
                = mapIdentityServiceResponseMapper.mapIdentityPost(userSyncRequest);
        log.debug(SERVICE_NAME + "POST /v1/user response: " + toJson(ossMapIdentitySyncFromMcipResponse));
        return Response.ok(ossMapIdentitySyncFromMcipResponse).build();
    }

    private String toJson(UserSyncRequest userSyncRequest) {
        return jacksonMapper.toJson(userSyncRequest);
    }

    private String toJson(OssMapIdentitySyncFromMcipResponse ossMapIdentitySyncFromMcipResponse) {
        return jacksonMapper.toJson(ossMapIdentitySyncFromMcipResponse);
    }
}
