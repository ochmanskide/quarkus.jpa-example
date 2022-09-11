package de.ochmanski.microservices.oss.module_a.module_a_service_rest.api;

import de.ochmanski.microservices.oss.module_a.module_a_service_rest.model.OssSendRevocationlistSyncRequest;
import de.ochmanski.microservices.oss.module_a.module_a_service_rest.model.OssSendRevocationlistSyncResponse;
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

@Path("/revocation-list")


@io.swagger.annotations.Api(description = "the revocation-list API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class RevocationListApi {

    @Inject
    RevocationListApiService service;

    @POST

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Transfer blocked credentials", notes = "The purpose of this call is the transfer of the list of blocked credential IDs. System integrators can choose whether they transfer all blocked entries or only those which are still valid at this point. The host system will transfer the list of backlisted entries and the service backend will respond with an empty response. ", response = OssSendRevocationlistSyncResponse.class, authorizations = {
            @io.swagger.annotations.Authorization(value = "apiKey")
    }, tags = {"Revocationlist",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = OssSendRevocationlistSyncResponse.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "No Authentication", response = Void.class)})
    public Response revocationListPost(@ApiParam(value = "") @Valid OssSendRevocationlistSyncRequest ossSendRevocationlistSyncRequest, @Context SecurityContext securityContext)
            throws NotFoundException {
        return service.revocationListPost(ossSendRevocationlistSyncRequest, securityContext);
    }
}
