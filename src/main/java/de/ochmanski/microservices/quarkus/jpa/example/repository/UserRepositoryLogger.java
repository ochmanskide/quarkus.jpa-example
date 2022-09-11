package de.ochmanski.microservices.quarkus.jpa.example.repository;

import de.ochmanski.microservices.quarkus.jpa.example.logger.JacksonMapper;
import de.ochmanski.microservices.quarkus.jpa.example.mapper.UserRequestDto;
import de.ochmanski.microservices.quarkus.jpa.example.mapper.UserResponseDto;
import lombok.extern.log4j.Log4j2;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Log4j2
@ApplicationScoped
public class UserRepositoryLogger {

    @Inject
    JacksonMapper jacksonMapper;

    @Inject
    UserRepositoryWrapper userRepositoryWrapper;

    public User findById(String id) {
        log.debug("select * from {} where id = {}", User.Table.USER, id);
        User found = userRepositoryWrapper.findById(id);
        log.debug("Found entity: {}", toJson(found));
        return found;
    }

    public User findByIdentity(String identity) {
        log.debug("select * from {} where identity = {}", User.Table.USER, identity);
        User found = userRepositoryWrapper.findByIdentity(identity);
        log.debug("Found entity: {}", toJson(found));
        return found;
    }

    public User findByToken(String token) {
        log.debug("select * from {} where token = {}", User.Table.USER, token);
        User found = userRepositoryWrapper.findByToken(token);
        log.debug("Found entity: {}", toJson(found));
        return found;
    }

    public User findByCredentialId(String credentialId) {
        log.debug("select * from {} where credentialId = {}", User.Table.USER, credentialId);
        User found = userRepositoryWrapper.findByCredentialId(credentialId);
        log.debug("Found entity: {}", toJson(found));
        return found;
    }

    public UserResponseDto save(UserRequestDto ossMapIdentity) {
        log.debug("insert into {} where identity = {}", User.Table.USER, ossMapIdentity.getIdentity());
        UserResponseDto saved = userRepositoryWrapper.save(ossMapIdentity);
        log.debug("Saved entity: {}", toJson(saved));
        return saved;
    }

    private String toJson(UserResponseDto saved) {
        return jacksonMapper.toJson(saved);
    }

    private String toJson(User saved) {
        return jacksonMapper.toJson(saved);
    }

    public boolean alreadyExists(UserResponseDto entity) {
        return userRepositoryWrapper.alreadyExists(entity);
    }
}
