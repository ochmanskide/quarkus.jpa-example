package de.ochmanski.microservices.quarkus.jpa.example.mapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.ochmanski.annotations.ExcludeFromJacocoGeneratedReport;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import lombok.extern.jackson.Jacksonized;

@RegisterForReflection(targets = {OssMapIdentitySyncFromMcipResponseDto.class, OssMapIdentitySyncFromMcipResponseDto.OssMapIdentitySyncFromMcipResponseDtoBuilder.class})
@ExcludeFromJacocoGeneratedReport
@Value
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Jacksonized
@FieldNameConstants
public class OssMapIdentitySyncFromMcipResponseDto {

    @Builder.Default
    OssSyncResponseStatusDto status = OssSyncResponseStatusDto.builder().build();

    @Builder.Default
    SyncInfoResponseDto syncInfoResponse = SyncInfoResponseDto.builder().build();
}
