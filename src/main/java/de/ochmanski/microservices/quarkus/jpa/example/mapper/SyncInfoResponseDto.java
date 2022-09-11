package de.ochmanski.microservices.quarkus.jpa.example.mapper;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import lombok.extern.jackson.Jacksonized;
import net.blueid.oss.mcip.rest.ExcludeFromJacocoGeneratedReport;

@RegisterForReflection(targets = {SyncInfoResponseDto.class, SyncInfoResponseDto.SyncInfoResponseDtoBuilder.class})
@ExcludeFromJacocoGeneratedReport
@Value
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Jacksonized
@FieldNameConstants
public class SyncInfoResponseDto {

    @Builder.Default
    OssMapIdentityResponseDto ossMapIdentityResponse = OssMapIdentityResponseDto.builder().build();
}
