package de.ochmanski.oss.mcip.rest.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.ochmanski.annotations.ExcludeFromJacocoGeneratedReport;
import de.ochmanski.oss.mcip.rest.Constants;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@RegisterForReflection(targets = {OssMapIdentityResponse.class, OssMapIdentityResponse.OssMapIdentityResponseBuilder.class})
@ExcludeFromJacocoGeneratedReport
@Value
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Jacksonized
@FieldNameConstants
public class OssMapIdentityResponse {

    UUID id;

    @Builder.Default
    String identity = Constants.BLANK;

    @Builder.Default
    String token = Constants.BLANK;

    @Builder.Default
    String credentialId = Constants.BLANK;
}
