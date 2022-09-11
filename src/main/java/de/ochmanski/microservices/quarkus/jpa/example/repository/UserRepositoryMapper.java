package de.ochmanski.microservices.quarkus.jpa.example.repository;

import de.ochmanski.microservices.quarkus.jpa.example.mapper.UserRequestDto;
import de.ochmanski.microservices.quarkus.jpa.example.mapper.UserResponseDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
public class UserRepositoryMapper {

    @Inject
    UserRepositoryLogger userRepositoryLogger;

    public UserResponseDto findById(String id) {
        User entity = userRepositoryLogger.findById(id);
        return map(entity);
    }

    public UserResponseDto findByIdentity(String identity) {
        User entity = userRepositoryLogger.findByIdentity(identity);
        return map(entity);
    }

    public UserResponseDto findByToken(String token) {
        User entity = userRepositoryLogger.findByToken(token);
        return map(entity);
    }

    public UserResponseDto findByCredentialId(String credentialId) {
        User entity = userRepositoryLogger.findByCredentialId(credentialId);
        return map(entity);
    }

    public UserResponseDto save(UserRequestDto dto) {
        return userRepositoryLogger.save(dto);
    }

    private UserResponseDto map(User entity) {
        return null == entity
                ? UserResponseDto.builder().build()
                : UserResponseDto.builder()
                .id(entity.getId())
                .identity(entity.getIdentity())
                .token(entity.getToken())
                .credentialId(entity.getCredentialId())
                .build();
    }

    public boolean alreadyExists(UserResponseDto entity) {
        return userRepositoryLogger.alreadyExists(entity);
    }
}
