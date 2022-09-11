package de.ochmanski.microservices.oss.module_a.module_a_service_rest.api;

import de.ochmanski.microservices.oss.module_a.module_a_service_rest.model.OssSyncInfoSyncRequest;
import de.ochmanski.microservices.oss.module_a.module_a_service_rest.model.OssSyncInfoSyncResponse;
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

@Path("/service-info")


@io.swagger.annotations.Api(description = "the service-info API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class ServiceInfoApi {

    @Inject
    ServiceInfoApiService service;

    @POST

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Contains information about the host. This includes a description, the version of the application, and the API version. This is the only call that works without authentication.", notes = "The content of the sync info request will describe the host system with a unique description and a version. The service back-end will respond with a unique service description and a version. The main purpose of this request is to establish a connection, validate the identity and supported versions of the participants. ", response = OssSyncInfoSyncResponse.class, authorizations = {
            @io.swagger.annotations.Authorization(value = "none")
    }, tags = {"Info",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = OssSyncInfoSyncResponse.class)})
    public Response serviceInfoPost(@ApiParam(value = "") @Valid OssSyncInfoSyncRequest ossSyncInfoSyncRequest, @Context SecurityContext securityContext)
            throws NotFoundException {
        return service.serviceInfoPost(ossSyncInfoSyncRequest, securityContext);
    }
}
