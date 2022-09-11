package de.ochmanski.oss.mcip.rest.controller;

import de.ochmanski.microservices.oss.module_a.module_a_service_rest.api.NotFoundException;
import de.ochmanski.microservices.oss.module_a.module_a_service_rest.model.OssMapIdentitySyncRequest;
import de.ochmanski.microservices.oss.module_a.module_a_service_rest.model.OssMapIdentitySyncResponse;
import de.ochmanski.oss.mcip.rest.response.OssMapIdentitySyncFromMcipResponse;
import io.swagger.annotations.*;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface MapIdentityApi {

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
    Response mapIdentityPost(
            @ApiParam(value = "") @Valid OssMapIdentitySyncRequest ossMapIdentitySyncRequest) throws NotFoundException;
}
