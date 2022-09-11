package de.ochmanski.microservices.quarkus.jpa.example.logger;

import de.ochmanski.microservices.oss.module_a.module_a_service_rest.model.OssMapIdentitySyncRequest;
import de.ochmanski.microservices.quarkus.jpa.example.mapper.MapIdentityResponseMapper;
import de.ochmanski.oss.mcip.rest.response.OssMapIdentitySyncFromMcipResponse;
import lombok.extern.log4j.Log4j2;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Log4j2
@ApplicationScoped
public class MapIdentityLogger {

    @Inject
    JacksonMapper jacksonMapper;

    @Inject
    MapIdentityResponseMapper mapIdentityServiceResponseMapper;

    private static final String SERVICE_NAME = "MCIP_SERVICE ";

    public Response mapIdentityPost(OssMapIdentitySyncRequest ossMapIdentitySyncRequest) {
        log.info(SERVICE_NAME + "POST /v1/map-identity request: " + toJson(ossMapIdentitySyncRequest));
        OssMapIdentitySyncFromMcipResponse ossMapIdentitySyncFromMcipResponse
                = mapIdentityServiceResponseMapper.mapIdentityPost(ossMapIdentitySyncRequest);
        log.debug(SERVICE_NAME + "POST /v1/map-identity response: " + toJson(ossMapIdentitySyncFromMcipResponse));
        return Response.ok(ossMapIdentitySyncFromMcipResponse).build();
    }

    private String toJson(OssMapIdentitySyncRequest ossMapIdentitySyncRequest) {
        return jacksonMapper.toJson(ossMapIdentitySyncRequest);
    }

    private String toJson(OssMapIdentitySyncFromMcipResponse ossMapIdentitySyncFromMcipResponse) {
        return jacksonMapper.toJson(ossMapIdentitySyncFromMcipResponse);
    }
}
