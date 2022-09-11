package de.ochmanski.microservices.quarkus.jpa.example.service;


import de.ochmanski.microservices.quarkus.jpa.example.mapper.*;
import de.ochmanski.microservices.quarkus.jpa.example.repository.UserRepositoryMapper;
import org.jetbrains.annotations.NotNull;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MapIdentityService {

    @Inject
    UserRepositoryMapper userRepositoryMapper;

    public OssMapIdentitySyncFromMcipResponseDto mapIdentityPost(OssMapIdentitySyncRequestDto ossMapIdentitySyncRequest) {
        return null == ossMapIdentitySyncRequest
                ? createEmpty()
                : save(ossMapIdentitySyncRequest);
    }

    public OssMapIdentitySyncFromMcipResponseDto findById(String id) {
        OssMapIdentityResponseDto entity = userRepositoryMapper.findById(id);
        return createDto(entity);
    }

    public OssMapIdentitySyncFromMcipResponseDto findByIdentity(String identity) {
        OssMapIdentityResponseDto entity = userRepositoryMapper.findByIdentity(identity);
        return createDto(entity);
    }

    public OssMapIdentitySyncFromMcipResponseDto findByToken(String token) {
        OssMapIdentityResponseDto entity = userRepositoryMapper.findByToken(token);
        return createDto(entity);
    }

    public OssMapIdentitySyncFromMcipResponseDto findByCredentialId(String credentialId) {
        OssMapIdentityResponseDto entity = userRepositoryMapper.findByCredentialId(credentialId);
        return createDto(entity);
    }

    public OssMapIdentitySyncFromMcipResponseDto save(OssMapIdentitySyncRequestDto ossMapIdentitySyncRequest) {
        UserRequestDto ossMapIdentity = map(ossMapIdentitySyncRequest);
        OssMapIdentityResponseDto entity = userRepositoryMapper.save(ossMapIdentity);
        return createDto(entity);
    }

    private OssMapIdentitySyncFromMcipResponseDto createEmpty() {
        return OssMapIdentitySyncFromMcipResponseDto.builder().build();
    }

    private OssMapIdentitySyncFromMcipResponseDto createDto(OssMapIdentityResponseDto entity) {
        return null == entity
                ? OssMapIdentitySyncFromMcipResponseDto.builder().build()
                : OssMapIdentitySyncFromMcipResponseDto.builder()
                .status(mapToStatus(entity))
                .syncInfoResponse(mapToSyncInfoResponse(entity))
                .build();
    }

    private OssSyncResponseStatusDto mapToStatus(OssMapIdentityResponseDto entity) {
        return null == entity
                ? OssSyncResponseStatusDto.builder().build()
                : OssSyncResponseStatusDto.builder()
                .code(200)
                .description(crateStatus(entity))
                .build();
    }

    @NotNull
    private String crateStatus(OssMapIdentityResponseDto entity) {
        return entity.isBrandNew() ? "new Identity created" : "Identity updated";
    }

    private boolean alreadyExists(OssMapIdentityResponseDto entity) {
        return userRepositoryMapper.alreadyExists(entity);
    }

    private SyncInfoResponseDto mapToSyncInfoResponse(OssMapIdentityResponseDto entity) {
        return null == entity
                ? SyncInfoResponseDto.builder().build()
                : SyncInfoResponseDto.builder()
                .ossMapIdentityResponse(mapToOssMapIdentityResponse(entity))
                .build();
    }

    private OssMapIdentityResponseDto mapToOssMapIdentityResponse(OssMapIdentityResponseDto response) {
        return null == response
                ? OssMapIdentityResponseDto.builder().build()
                : OssMapIdentityResponseDto.builder()
                .id(response.getId())
                .identity(response.getIdentity())
                .token(response.getToken())
                .credentialId(response.getCredentialId())
                .build();
    }

    private UserRequestDto map(OssMapIdentitySyncRequestDto ossMapIdentitySyncRequest) {
        UserRequestDto request = ossMapIdentitySyncRequest.getSyncInfoRequest();
        return null == request
                ? UserRequestDto.builder().build()
                : UserRequestDto.builder()
                .identity(request.getIdentity())
                .token(request.getToken())
                .credentialId(request.getCredentialId())
                .build();
    }
}
