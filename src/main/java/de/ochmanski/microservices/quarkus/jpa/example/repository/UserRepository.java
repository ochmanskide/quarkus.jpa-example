package de.ochmanski.microservices.quarkus.jpa.example.repository;


import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<User, UUID> {

    public PanacheQuery<User> findById(String id) {
        return find(User.Fields.id, id);
    }

    public PanacheQuery<User> findByIdentity(String identity) {
        return find(User.Fields.identity, identity);
    }

    public PanacheQuery<User> findByToken(String token) {
        return find(User.Fields.token, token);
    }

    public PanacheQuery<User> findByCredentialId(String credentialId) {
        return find(User.Fields.credentialId, credentialId);
    }

    public void persistRaw(User detached) {
        persist(detached);
    }
}
