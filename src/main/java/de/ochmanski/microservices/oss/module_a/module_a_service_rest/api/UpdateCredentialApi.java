package de.ochmanski.microservices.oss.module_a.module_a_service_rest.api;

import de.ochmanski.microservices.oss.module_a.module_a_service_rest.model.OssUpdateCredentialSyncRequest;
import de.ochmanski.microservices.oss.module_a.module_a_service_rest.model.OssUpdateCredentialSyncResponse;
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

@Path("/update-credential")


@io.swagger.annotations.Api(description = "the update-credential API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class UpdateCredentialApi {

    @Inject
    UpdateCredentialApiService service;

    @POST

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Send one credential", notes = "The credential data will contain the full credential OSS SO info, data. Revocationlist and customer extension data is optional. This request will be called when a credential is created or modified and will contain the data for one credential ID. ", response = OssUpdateCredentialSyncResponse.class, authorizations = {
            @io.swagger.annotations.Authorization(value = "apiKey")
    }, tags = {"Credential data",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = OssUpdateCredentialSyncResponse.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "No Authentication", response = Void.class)})
    public Response updateCredentialPost(@ApiParam(value = "") @Valid OssUpdateCredentialSyncRequest ossUpdateCredentialSyncRequest, @Context SecurityContext securityContext)
            throws NotFoundException {
        return service.updateCredentialPost(ossUpdateCredentialSyncRequest, securityContext);
    }
}
