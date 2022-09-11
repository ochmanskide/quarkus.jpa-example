package de.ochmanski.microservices.quarkus.jpa.example.controller;

import de.ochmanski.microservices.quarkus.jpa.example.logger.MapIdentityLogger;
import io.swagger.annotations.*;
import net.blueid.microservices.oss.module_a.module_a_service_rest.api.NotFoundException;
import net.blueid.microservices.oss.module_a.module_a_service_rest.model.OssMapIdentitySyncRequest;
import net.blueid.microservices.oss.module_a.module_a_service_rest.model.OssMapIdentitySyncResponse;
import net.blueid.oss.mcip.rest.response.OssMapIdentitySyncFromMcipResponse;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@OpenAPIDefinition(
        info = @org.eclipse.microprofile.openapi.annotations.info.Info(
                title = "Access Permission",
                version = "v1",
                description = "Mock access Permission endpoints from ac-api"
        )
)
@Path("/v1/map-identity")
@Api(description = "the map-identity API")
public class MapIdentityController implements net.blueid.oss.mcip.rest.controller.MapIdentityApi {

    @Inject
    MapIdentityLogger mapIdentityLogger;

    @Override
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Map an identity to credentialId",
            notes = "Map an identity in the form of `email#john.doe@example.com` to a credentialId " +
                    "(no formatting restrictions) for use in subsequent requests. ",
            response = OssMapIdentitySyncResponse.class,
            authorizations = {@Authorization(value = "apiKey")},
            tags = {"Credential data",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = OssMapIdentitySyncFromMcipResponse.class),
            @ApiResponse(code = 401, message = "No Authentication", response = Void.class)})
    public Response mapIdentityPost(
            @ApiParam(value = "") @Valid OssMapIdentitySyncRequest ossMapIdentitySyncRequest) throws NotFoundException {
        return mapIdentityLogger.mapIdentityPost(ossMapIdentitySyncRequest);
    }
}
