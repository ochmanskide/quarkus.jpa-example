package de.ochmanski.microservices.oss.module_a.module_a_service_rest.api;

import de.ochmanski.microservices.oss.module_a.module_a_service_rest.model.OssMapIdentitySyncRequest;
import de.ochmanski.microservices.oss.module_a.module_a_service_rest.model.OssMapIdentitySyncResponse;
import io.swagger.annotations.ApiParam;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/map-identity")


@io.swagger.annotations.Api(description = "the map-identity API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class MapIdentityApi {

    @Inject
    MapIdentityApiService service;

    @POST

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Map an identity to credentialId", notes = "Map an identity in the form of `email#john.doe@example.com` to a credentialId (no formatting restrictions) for use in subsequent requests. ", response = OssMapIdentitySyncResponse.class, authorizations = {
            @io.swagger.annotations.Authorization(value = "apiKey")
    }, tags = {"Credential data",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = OssMapIdentitySyncResponse.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "No Authentication", response = Void.class)})
    public Response mapIdentityPost(@ApiParam(value = "") @Valid OssMapIdentitySyncRequest ossMapIdentitySyncRequest, @Context SecurityContext securityContext)
            throws NotFoundException {
        return service.mapIdentityPost(ossMapIdentitySyncRequest, securityContext);
    }
}
