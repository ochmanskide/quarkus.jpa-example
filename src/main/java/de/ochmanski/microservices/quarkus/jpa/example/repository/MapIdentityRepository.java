package de.ochmanski.microservices.quarkus.jpa.example.repository;


import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class MapIdentityRepository implements PanacheRepositoryBase<OssMapIdentity, UUID> {

    public PanacheQuery<OssMapIdentity> findById(String id) {
        return find(OssMapIdentity.Fields.id, id);
    }

    public PanacheQuery<OssMapIdentity> findByIdentity(String identity) {
        return find(OssMapIdentity.Fields.identity, identity);
    }

    public PanacheQuery<OssMapIdentity> findByToken(String token) {
        return find(OssMapIdentity.Fields.token, token);
    }

    public PanacheQuery<OssMapIdentity> findByCredentialId(String credentialId) {
        return find(OssMapIdentity.Fields.credentialId, credentialId);
    }

    public void persistRaw(OssMapIdentity detached) {
        persist(detached);
    }
}
