package de.ochmanski.microservices.quarkus.jpa.example.rest.controller;

import de.ochmanski.generated.api.NotFoundException;
import de.ochmanski.generated.model.UserSyncRequest;
import de.ochmanski.generated.model.OssMapIdentitySyncResponse;
import de.ochmanski.microservices.quarkus.jpa.example.rest.response.UserResponse;
import io.swagger.annotations.*;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface UserApi {

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
            @ApiResponse(code = 200, message = "OK", response = UserResponse.class),
            @ApiResponse(code = 401, message = "No Authentication", response = Void.class)})
    Response update(
            @ApiParam(value = "") @Valid UserSyncRequest userSyncRequest) throws NotFoundException;
}
