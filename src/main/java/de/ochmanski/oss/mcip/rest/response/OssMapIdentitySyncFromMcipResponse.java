package de.ochmanski.oss.mcip.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.ochmanski.annotations.ExcludeFromJacocoGeneratedReport;
import de.ochmanski.microservices.oss.module_a.module_a_service_rest.model.OssSyncResponseStatus;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import lombok.extern.jackson.Jacksonized;

@RegisterForReflection(targets = {OssMapIdentitySyncFromMcipResponse.class, OssMapIdentitySyncFromMcipResponse.OssMapIdentitySyncFromMcipResponseBuilder.class})
@ExcludeFromJacocoGeneratedReport
@Value
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Jacksonized
@FieldNameConstants
public class OssMapIdentitySyncFromMcipResponse {

  @Builder.Default
  OssSyncResponseStatus status = new OssSyncResponseStatus();

  @Builder.Default
  SyncInfoResponse syncInfoResponse = SyncInfoResponse.builder().build();

}
