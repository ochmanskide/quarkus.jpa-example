package de.ochmanski.microservices.quarkus.jpa.example.mapper;

import de.ochmanski.generated.model.OssMapIdentityRequest;
import de.ochmanski.generated.model.UserSyncRequest;
import de.ochmanski.generated.model.OssSyncResponseStatus;
import de.ochmanski.microservices.quarkus.jpa.example.service.UserService;
import de.ochmanski.microservices.quarkus.jpa.example.rest.response.OssMapIdentityResponse;
import de.ochmanski.microservices.quarkus.jpa.example.rest.response.OssMapIdentitySyncFromMcipResponse;
import de.ochmanski.microservices.quarkus.jpa.example.rest.response.SyncInfoResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserResponseMapper {

    @Inject
    UserService userService;

    public OssMapIdentitySyncFromMcipResponse mapIdentityPost(UserSyncRequest userSyncRequest) {
        UserSyncRequestDto dto = map(userSyncRequest);
        OssMapIdentitySyncFromMcipResponseDto response = userService.mapIdentityPost(dto);
        return map(response);
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
        UserResponseDto ossMapIdentityResponse = dto.getOssMapIdentityResponse();
        return null == ossMapIdentityResponse
                ? OssMapIdentityResponse.builder().build()
                : OssMapIdentityResponse.builder()
                .id(ossMapIdentityResponse.getId())
                .identity(ossMapIdentityResponse.getIdentity())
                .token(ossMapIdentityResponse.getToken())
                .credentialId(ossMapIdentityResponse.getCredentialId())
                .build();
    }

    private UserSyncRequestDto map(UserSyncRequest userSyncRequest) {
        return null == userSyncRequest
                ? UserSyncRequestDto.builder().build()
                : UserSyncRequestDto.builder()
                .syncInfoRequest(mapOssMapIdentitySyncRequest(userSyncRequest))
                .build();
    }

    private UserRequestDto mapOssMapIdentitySyncRequest(UserSyncRequest userSyncRequest) {
        OssMapIdentityRequest syncInfoRequest = userSyncRequest.getSyncInfoRequest();
        return null == syncInfoRequest
                ? UserRequestDto.builder().build()
                : UserRequestDto.builder()
                .identity(syncInfoRequest.getIdentity())
                .token(syncInfoRequest.getToken())
                .credentialId(syncInfoRequest.getCredentialId())
                .build();
    }
}
