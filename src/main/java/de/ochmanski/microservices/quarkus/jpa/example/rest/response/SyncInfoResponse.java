package de.ochmanski.microservices.quarkus.jpa.example.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.ochmanski.annotations.ExcludeFromJacocoGeneratedReport;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import lombok.extern.jackson.Jacksonized;

@RegisterForReflection(targets = {SyncInfoResponse.class, SyncInfoResponse.SyncInfoResponseBuilder.class})
@ExcludeFromJacocoGeneratedReport
@Value
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Jacksonized
@FieldNameConstants
public class SyncInfoResponse {

    @Builder.Default
    OssMapIdentityResponse ossMapIdentityResponse = OssMapIdentityResponse.builder().build();
}
