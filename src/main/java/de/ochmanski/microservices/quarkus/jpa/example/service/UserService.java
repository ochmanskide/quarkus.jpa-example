package de.ochmanski.microservices.quarkus.jpa.example.service;


import de.ochmanski.microservices.quarkus.jpa.example.mapper.*;
import de.ochmanski.microservices.quarkus.jpa.example.repository.UserRepositoryMapper;
import org.jetbrains.annotations.NotNull;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepositoryMapper userRepositoryMapper;

    public OssMapIdentitySyncFromMcipResponseDto mapIdentityPost(UserSyncRequestDto ossMapIdentitySyncRequest) {
        return null == ossMapIdentitySyncRequest
                ? createEmpty()
                : save(ossMapIdentitySyncRequest);
    }

    public OssMapIdentitySyncFromMcipResponseDto findById(String id) {
        UserResponseDto entity = userRepositoryMapper.findById(id);
        return createDto(entity);
    }

    public OssMapIdentitySyncFromMcipResponseDto findByIdentity(String identity) {
        UserResponseDto entity = userRepositoryMapper.findByIdentity(identity);
        return createDto(entity);
    }

    public OssMapIdentitySyncFromMcipResponseDto findByToken(String token) {
        UserResponseDto entity = userRepositoryMapper.findByToken(token);
        return createDto(entity);
    }

    public OssMapIdentitySyncFromMcipResponseDto findByCredentialId(String credentialId) {
        UserResponseDto entity = userRepositoryMapper.findByCredentialId(credentialId);
        return createDto(entity);
    }

    public OssMapIdentitySyncFromMcipResponseDto save(UserSyncRequestDto ossMapIdentitySyncRequest) {
        UserRequestDto ossMapIdentity = map(ossMapIdentitySyncRequest);
        UserResponseDto entity = userRepositoryMapper.save(ossMapIdentity);
        return createDto(entity);
    }

    private OssMapIdentitySyncFromMcipResponseDto createEmpty() {
        return OssMapIdentitySyncFromMcipResponseDto.builder().build();
    }

    private OssMapIdentitySyncFromMcipResponseDto createDto(UserResponseDto entity) {
        return null == entity
                ? OssMapIdentitySyncFromMcipResponseDto.builder().build()
                : OssMapIdentitySyncFromMcipResponseDto.builder()
                .status(mapToStatus(entity))
                .syncInfoResponse(mapToSyncInfoResponse(entity))
                .build();
    }

    private OssSyncResponseStatusDto mapToStatus(UserResponseDto entity) {
        return null == entity
                ? OssSyncResponseStatusDto.builder().build()
                : OssSyncResponseStatusDto.builder()
                .code(200)
                .description(crateStatus(entity))
                .build();
    }

    @NotNull
    private String crateStatus(UserResponseDto entity) {
        return entity.isBrandNew() ? "new Identity created" : "Identity updated";
    }

    private boolean alreadyExists(UserResponseDto entity) {
        return userRepositoryMapper.alreadyExists(entity);
    }

    private SyncInfoResponseDto mapToSyncInfoResponse(UserResponseDto entity) {
        return null == entity
                ? SyncInfoResponseDto.builder().build()
                : SyncInfoResponseDto.builder()
                .ossMapIdentityResponse(mapToOssMapIdentityResponse(entity))
                .build();
    }

    private UserResponseDto mapToOssMapIdentityResponse(UserResponseDto response) {
        return null == response
                ? UserResponseDto.builder().build()
                : UserResponseDto.builder()
                .id(response.getId())
                .identity(response.getIdentity())
                .token(response.getToken())
                .credentialId(response.getCredentialId())
                .build();
    }

    private UserRequestDto map(UserSyncRequestDto ossMapIdentitySyncRequest) {
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
