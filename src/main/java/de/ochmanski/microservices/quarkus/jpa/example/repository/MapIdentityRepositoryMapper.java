package de.ochmanski.microservices.quarkus.jpa.example.repository;

import de.ochmanski.microservices.quarkus.jpa.example.mapper.OssMapIdentityRequestDto;
import de.ochmanski.microservices.quarkus.jpa.example.mapper.OssMapIdentityResponseDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
public class MapIdentityRepositoryMapper {

    @Inject
    MapIdentityRepositoryLogger mapIdentityRepositoryLogger;

    public OssMapIdentityResponseDto findById(String id) {
        OssMapIdentity entity = mapIdentityRepositoryLogger.findById(id);
        return map(entity);
    }

    public OssMapIdentityResponseDto findByIdentity(String identity) {
        OssMapIdentity entity = mapIdentityRepositoryLogger.findByIdentity(identity);
        return map(entity);
    }

    public OssMapIdentityResponseDto findByToken(String token) {
        OssMapIdentity entity = mapIdentityRepositoryLogger.findByToken(token);
        return map(entity);
    }

    public OssMapIdentityResponseDto findByCredentialId(String credentialId) {
        OssMapIdentity entity = mapIdentityRepositoryLogger.findByCredentialId(credentialId);
        return map(entity);
    }

    public OssMapIdentityResponseDto save(OssMapIdentityRequestDto dto) {
        return mapIdentityRepositoryLogger.save(dto);
    }

    private OssMapIdentityResponseDto map(OssMapIdentity entity) {
        return null == entity
                ? OssMapIdentityResponseDto.builder().build()
                : OssMapIdentityResponseDto.builder()
                .id(entity.getId())
                .identity(entity.getIdentity())
                .token(entity.getToken())
                .credentialId(entity.getCredentialId())
                .build();
    }

    public boolean alreadyExists(OssMapIdentityResponseDto entity) {
        return mapIdentityRepositoryLogger.alreadyExists(entity);
    }
}
