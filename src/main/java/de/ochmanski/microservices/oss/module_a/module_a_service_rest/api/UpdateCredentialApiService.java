package de.ochmanski.microservices.oss.module_a.module_a_service_rest.api;

import de.ochmanski.microservices.oss.module_a.module_a_service_rest.model.OssUpdateCredentialSyncRequest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public interface UpdateCredentialApiService {
      Response updateCredentialPost(OssUpdateCredentialSyncRequest ossUpdateCredentialSyncRequest, SecurityContext securityContext)
              throws NotFoundException;
}
