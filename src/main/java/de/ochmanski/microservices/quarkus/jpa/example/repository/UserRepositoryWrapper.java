package de.ochmanski.microservices.quarkus.jpa.example.repository;

import de.ochmanski.microservices.quarkus.jpa.example.logger.JacksonMapper;
import de.ochmanski.microservices.quarkus.jpa.example.mapper.UserRequestDto;
import de.ochmanski.microservices.quarkus.jpa.example.mapper.UserResponseDto;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import lombok.extern.log4j.Log4j2;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Log4j2
@Transactional
@ApplicationScoped
public class UserRepositoryWrapper {

    @Inject
    JacksonMapper jacksonMapper;

    @Inject
    UserRepository userRepository;

    public User findById(String id) {
        return userRepository.findById(id).firstResult();
    }

    public User findByIdentity(String identity) {
        return userRepository.findByIdentity(identity).firstResult();
    }

    public User findByToken(String token) {
        return userRepository.findByToken(token).firstResult();
    }

    public User findByCredentialId(String credentialId) {
        return userRepository.findByCredentialId(credentialId).firstResult();
    }

    public UserResponseDto save(UserRequestDto detached) {
        User attached = findByIdentity(detached);
        return null == attached ? create(detached) : update(attached, detached);
    }

    private User findByIdentity(UserRequestDto detached) {
        if (null == detached) {
            return null;
        }
        if (null == detached.getIdentity() || detached.getIdentity().isBlank()) {
            return null;
        }
        return findByIdentityDelegate(detached).firstResult();
    }

    private PanacheQuery<User> findByIdentityDelegate(UserRequestDto detached) {
        return userRepository.findByIdentity(detached.getIdentity());
    }

    private UserResponseDto create(UserRequestDto detached) {
        log.debug("Entity with ID {} was not found. It will be created.", toJson(detached));
        User entity = persist(detached);
        return mapAsNew(entity);
    }

    private UserResponseDto mapAsNew(User entity) {
        return null == entity
                ? UserResponseDto.builder().build()
                : UserResponseDto.builder()
                .id(entity.getId())
                .identity(entity.getIdentity())
                .token(entity.getToken())
                .credentialId(entity.getCredentialId())
                .brandNew(true)
                .build();
    }

    private UserResponseDto update(User attached, UserRequestDto detached) {
        log.debug("Update existing entity with ID: {}", attached.getIdentity());
        attached.setIdentity(detached.getIdentity());
        attached.setToken(detached.getToken());
        attached.setCredentialId(detached.getCredentialId());
        User entity = persistDelegate(attached);
        return mapAsOld(entity);
    }

    private UserResponseDto mapAsOld(User entity) {
        return null == entity
                ? UserResponseDto.builder().build()
                : UserResponseDto.builder()
                .id(entity.getId())
                .identity(entity.getIdentity())
                .token(entity.getToken())
                .credentialId(entity.getCredentialId())
                .brandNew(false)
                .build();
    }

    private User persist(UserRequestDto dto) {
        User detached = map(dto);
        return persistDelegate(detached);
    }

    private User map(UserRequestDto dto) {
        return null == dto
                ? User.builder().build()
                : User.builder()
                .identity(dto.getIdentity())
                .token(dto.getToken())
                .credentialId(dto.getCredentialId())
                .build();
    }

    private User persistDelegate(User detached) {
        userRepository.persistRaw(detached);
        return detached;
    }

    private String toJson(UserRequestDto entity) {
        return jacksonMapper.toJson(entity);
    }

    public boolean alreadyExists(UserResponseDto entity) {
        return userRepository.findByIdentity(entity.getIdentity()).count() == 1L;
    }
}
