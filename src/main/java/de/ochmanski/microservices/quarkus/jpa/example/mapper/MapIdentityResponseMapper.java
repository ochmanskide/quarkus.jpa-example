package de.ochmanski.microservices.quarkus.jpa.example.mapper;

import de.ochmanski.microservices.quarkus.jpa.example.service.MapIdentityService;
import net.blueid.microservices.oss.module_a.module_a_service_rest.model.OssMapIdentityRequest;
import net.blueid.microservices.oss.module_a.module_a_service_rest.model.OssMapIdentitySyncRequest;
import net.blueid.microservices.oss.module_a.module_a_service_rest.model.OssSyncResponseStatus;
import net.blueid.oss.mcip.rest.response.OssMapIdentityResponse;
import net.blueid.oss.mcip.rest.response.OssMapIdentitySyncFromMcipResponse;
import net.blueid.oss.mcip.rest.response.SyncInfoResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MapIdentityResponseMapper {

    @Inject
    MapIdentityService mapIdentityService;

    public OssMapIdentitySyncFromMcipResponse mapIdentityPost(OssMapIdentitySyncRequest ossMapIdentitySyncRequest) {
        OssMapIdentitySyncRequestDto dto = map(ossMapIdentitySyncRequest);
        OssMapIdentitySyncFromMcipResponseDto ossMapIdentitySyncFromMcipResponse = mapIdentityService.mapIdentityPost(dto);
        return map(ossMapIdentitySyncFromMcipResponse);
    }

    private OssMapIdentitySyncFromMcipResponse map(OssMapIdentitySyncFromMcipResponseDto dto) {
        return null == dto
                ? OssMapIdentitySyncFromMcipResponse.builder().build()
                : OssMapIdentitySyncFromMcipResponse.builder()
                .status(mapStatus(dto))
                .syncInfoResponse(mapSyncInfoResponse(dto))
                .build();
    }

    private OssSyncResponseStatus mapStatus(OssMapIdentitySyncFromMcipResponseDto dto) {
        OssSyncResponseStatusDto status = dto.getStatus();
        return null == status
                ? new OssSyncResponseStatus()
                : createOssSyncResponseStatus(status);
    }

    private OssSyncResponseStatus createOssSyncResponseStatus(OssSyncResponseStatusDto dto) {
        OssSyncResponseStatus ossSyncResponseStatus = new OssSyncResponseStatus();
        ossSyncResponseStatus.setDescription(dto.getDescription());
        ossSyncResponseStatus.setCode(dto.getCode());
        return ossSyncResponseStatus;
    }

    private SyncInfoResponse mapSyncInfoResponse(OssMapIdentitySyncFromMcipResponseDto dto) {
        SyncInfoResponseDto syncInfoResponse = dto.getSyncInfoResponse();
        return null == syncInfoResponse
                ? SyncInfoResponse.builder().build()
                : SyncInfoResponse.builder()
                .ossMapIdentityResponse(mapOssMapIdentityResponse(syncInfoResponse))
                .build();
    }

    private OssMapIdentityResponse mapOssMapIdentityResponse(SyncInfoResponseDto dto) {
        OssMapIdentityResponseDto ossMapIdentityResponse = dto.getOssMapIdentityResponse();
        return null == ossMapIdentityResponse
                ? OssMapIdentityResponse.builder().build()
                : OssMapIdentityResponse.builder()
                .id(ossMapIdentityResponse.getId())
                .identity(ossMapIdentityResponse.getIdentity())
                .token(ossMapIdentityResponse.getToken())
                .credentialId(ossMapIdentityResponse.getCredentialId())
                .build();
    }

    private OssMapIdentitySyncRequestDto map(OssMapIdentitySyncRequest ossMapIdentitySyncRequest) {
        return null == ossMapIdentitySyncRequest
                ? OssMapIdentitySyncRequestDto.builder().build()
                : OssMapIdentitySyncRequestDto.builder()
                .syncInfoRequest(mapOssMapIdentitySyncRequest(ossMapIdentitySyncRequest))
                .build();
    }

    private OssMapIdentityRequestDto mapOssMapIdentitySyncRequest(OssMapIdentitySyncRequest ossMapIdentitySyncRequest) {
        OssMapIdentityRequest syncInfoRequest = ossMapIdentitySyncRequest.getSyncInfoRequest();
        return null == syncInfoRequest
                ? OssMapIdentityRequestDto.builder().build()
                : OssMapIdentityRequestDto.builder()
                .identity(syncInfoRequest.getIdentity())
                .token(syncInfoRequest.getToken())
                .credentialId(syncInfoRequest.getCredentialId())
                .build();
    }
}
