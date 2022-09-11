package de.ochmanski.microservices.quarkus.jpa.example.repository;

import de.ochmanski.microservices.quarkus.jpa.example.logger.JacksonMapper;
import de.ochmanski.microservices.quarkus.jpa.example.mapper.OssMapIdentityRequestDto;
import de.ochmanski.microservices.quarkus.jpa.example.mapper.OssMapIdentityResponseDto;
import lombok.extern.log4j.Log4j2;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Log4j2
@ApplicationScoped
public class MapIdentityRepositoryLogger {

    @Inject
    JacksonMapper jacksonMapper;

    @Inject
    MapIdentityRepositoryWrapper mapIdentityRepositoryWrapper;

    public OssMapIdentity findById(String id) {
        log.debug("select * from {} where id = {}", OssMapIdentity.Table.OSS_MAP_IDENTITY, id);
        OssMapIdentity found = mapIdentityRepositoryWrapper.findById(id);
        log.debug("Found entity: {}", toJson(found));
        return found;
    }

    public OssMapIdentity findByIdentity(String identity) {
        log.debug("select * from {} where identity = {}", OssMapIdentity.Table.OSS_MAP_IDENTITY, identity);
        OssMapIdentity found = mapIdentityRepositoryWrapper.findByIdentity(identity);
        log.debug("Found entity: {}", toJson(found));
        return found;
    }

    public OssMapIdentity findByToken(String token) {
        log.debug("select * from {} where token = {}", OssMapIdentity.Table.OSS_MAP_IDENTITY, token);
        OssMapIdentity found = mapIdentityRepositoryWrapper.findByToken(token);
        log.debug("Found entity: {}", toJson(found));
        return found;
    }

    public OssMapIdentity findByCredentialId(String credentialId) {
        log.debug("select * from {} where credentialId = {}", OssMapIdentity.Table.OSS_MAP_IDENTITY, credentialId);
        OssMapIdentity found = mapIdentityRepositoryWrapper.findByCredentialId(credentialId);
        log.debug("Found entity: {}", toJson(found));
        return found;
    }

    public OssMapIdentityResponseDto save(OssMapIdentityRequestDto ossMapIdentity) {
        log.debug("insert into {} where identity = {}", OssMapIdentity.Table.OSS_MAP_IDENTITY, ossMapIdentity.getIdentity());
        OssMapIdentityResponseDto saved = mapIdentityRepositoryWrapper.save(ossMapIdentity);
        log.debug("Saved entity: {}", toJson(saved));
        return saved;
    }

    private String toJson(OssMapIdentityResponseDto saved) {
        return jacksonMapper.toJson(saved);
    }

    private String toJson(OssMapIdentity saved) {
        return jacksonMapper.toJson(saved);
    }

    public boolean alreadyExists(OssMapIdentityResponseDto entity) {
        return mapIdentityRepositoryWrapper.alreadyExists(entity);
    }
}
