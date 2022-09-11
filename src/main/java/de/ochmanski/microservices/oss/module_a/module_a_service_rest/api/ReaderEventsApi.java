package de.ochmanski.microservices.oss.module_a.module_a_service_rest.api;

import de.ochmanski.microservices.oss.module_a.module_a_service_rest.model.OssGetReaderMessagesSyncRequest;
import de.ochmanski.microservices.oss.module_a.module_a_service_rest.model.OssGetReaderMessagesSyncResponse;
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

@Path("/reader-events")


@io.swagger.annotations.Api(description = "the reader-events API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class ReaderEventsApi {

    @Inject
    ReaderEventsApiService service;

    @POST

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Transfer event data back from doorlock to host system (renamed from *GetEvents*)", notes = "This call is used to transfer event data back from the service backend to the host system. The protocol will append the credential id to the existing OSS event structure. The host system will ask for all events that occurred since the last synchronization. The request message will contain a field for the last known event id. The service backend will respond with a list of events that occurred after the last known event id. If the service backend uses a database, it is easy to use an auto-incremented field for this purpose. One advantage of this is that a new host system could fetch all events. Another advantage is that if no new events occurred only a couple of bytes will be transferred. It is the responsibility of the service backend to decide when or if to delete old events. ", response = OssGetReaderMessagesSyncResponse.class, authorizations = {
            @io.swagger.annotations.Authorization(value = "apiKey")
    }, tags = {"Events",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = OssGetReaderMessagesSyncResponse.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "No Authentication", response = Void.class)})
    public Response readerEventsPost(@ApiParam(value = "") @Valid OssGetReaderMessagesSyncRequest ossGetReaderMessagesSyncRequest, @Context SecurityContext securityContext)
            throws NotFoundException {
        return service.readerEventsPost(ossGetReaderMessagesSyncRequest, securityContext);
    }
}
