package de.ochmanski.microservices.quarkus.jpa.example.repository;

import de.ochmanski.microservices.quarkus.jpa.example.mapper.UserRequestDto;
import de.ochmanski.microservices.quarkus.jpa.example.mapper.OssMapIdentityResponseDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
public class UserRepositoryMapper {

    @Inject
    UserRepositoryLogger userRepositoryLogger;

    public OssMapIdentityResponseDto findById(String id) {
        User entity = userRepositoryLogger.findById(id);
        return map(entity);
    }

    public OssMapIdentityResponseDto findByIdentity(String identity) {
        User entity = userRepositoryLogger.findByIdentity(identity);
        return map(entity);
    }

    public OssMapIdentityResponseDto findByToken(String token) {
        User entity = userRepositoryLogger.findByToken(token);
        return map(entity);
    }

    public OssMapIdentityResponseDto findByCredentialId(String credentialId) {
        User entity = userRepositoryLogger.findByCredentialId(credentialId);
        return map(entity);
    }

    public OssMapIdentityResponseDto save(UserRequestDto dto) {
        return userRepositoryLogger.save(dto);
    }

    private OssMapIdentityResponseDto map(User entity) {
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
        return userRepositoryLogger.alreadyExists(entity);
    }
}
