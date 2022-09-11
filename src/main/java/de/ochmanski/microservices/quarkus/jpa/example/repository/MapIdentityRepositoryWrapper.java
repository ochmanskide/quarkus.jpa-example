package de.ochmanski.microservices.quarkus.jpa.example.repository;

import de.ochmanski.microservices.quarkus.jpa.example.logger.JacksonMapper;
import de.ochmanski.microservices.quarkus.jpa.example.mapper.OssMapIdentityRequestDto;
import de.ochmanski.microservices.quarkus.jpa.example.mapper.OssMapIdentityResponseDto;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import lombok.extern.log4j.Log4j2;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Log4j2
@Transactional
@ApplicationScoped
public class MapIdentityRepositoryWrapper {

    @Inject
    JacksonMapper jacksonMapper;

    @Inject
    MapIdentityRepository mapIdentityRepository;

    public OssMapIdentity findById(String id) {
        return mapIdentityRepository.findById(id).firstResult();
    }

    public OssMapIdentity findByIdentity(String identity) {
        return mapIdentityRepository.findByIdentity(identity).firstResult();
    }

    public OssMapIdentity findByToken(String token) {
        return mapIdentityRepository.findByToken(token).firstResult();
    }

    public OssMapIdentity findByCredentialId(String credentialId) {
        return mapIdentityRepository.findByCredentialId(credentialId).firstResult();
    }

    public OssMapIdentityResponseDto save(OssMapIdentityRequestDto detached) {
        OssMapIdentity attached = findByIdentity(detached);
        return null == attached ? create(detached) : update(attached, detached);
    }

    private OssMapIdentity findByIdentity(OssMapIdentityRequestDto detached) {
        if (null == detached) {
            return null;
        }
        if (null == detached.getIdentity() || detached.getIdentity().isBlank()) {
            return null;
        }
        return findByIdentityDelegate(detached).firstResult();
    }

    private PanacheQuery<OssMapIdentity> findByIdentityDelegate(OssMapIdentityRequestDto detached) {
        return mapIdentityRepository.findByIdentity(detached.getIdentity());
    }

    private OssMapIdentityResponseDto create(OssMapIdentityRequestDto detached) {
        log.debug("Entity with ID {} was not found. It will be created.", toJson(detached));
        OssMapIdentity entity = persist(detached);
        return mapAsNew(entity);
    }

    private OssMapIdentityResponseDto mapAsNew(OssMapIdentity entity) {
        return null == entity
                ? OssMapIdentityResponseDto.builder().build()
                : OssMapIdentityResponseDto.builder()
                .id(entity.getId())
                .identity(entity.getIdentity())
                .token(entity.getToken())
                .credentialId(entity.getCredentialId())
                .brandNew(true)
                .build();
    }

    private OssMapIdentityResponseDto update(OssMapIdentity attached, OssMapIdentityRequestDto detached) {
        log.debug("Update existing entity with ID: {}", attached.getIdentity());
        attached.setIdentity(detached.getIdentity());
        attached.setToken(detached.getToken());
        attached.setCredentialId(detached.getCredentialId());
        OssMapIdentity entity = persistDelegate(attached);
        return mapAsOld(entity);
    }

    private OssMapIdentityResponseDto mapAsOld(OssMapIdentity entity) {
        return null == entity
                ? OssMapIdentityResponseDto.builder().build()
                : OssMapIdentityResponseDto.builder()
                .id(entity.getId())
                .identity(entity.getIdentity())
                .token(entity.getToken())
                .credentialId(entity.getCredentialId())
                .brandNew(false)
                .build();
    }

    private OssMapIdentity persist(OssMapIdentityRequestDto dto) {
        OssMapIdentity detached = map(dto);
        return persistDelegate(detached);
    }

    private OssMapIdentity map(OssMapIdentityRequestDto dto) {
        return null == dto
                ? OssMapIdentity.builder().build()
                : OssMapIdentity.builder()
                .identity(dto.getIdentity())
                .token(dto.getToken())
                .credentialId(dto.getCredentialId())
                .build();
    }

    private OssMapIdentity persistDelegate(OssMapIdentity detached) {
        mapIdentityRepository.persistRaw(detached);
        return detached;
    }

    private String toJson(OssMapIdentityRequestDto entity) {
        return jacksonMapper.toJson(entity);
    }

    public boolean alreadyExists(OssMapIdentityResponseDto entity) {
        return mapIdentityRepository.findByIdentity(entity.getIdentity()).count() == 1L;
    }
}
