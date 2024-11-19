package edu.learn.couchbase.repositories;

import edu.learn.couchbase.entities.User;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.core.ExecutableFindByIdOperation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepositoryTemplate {
    private final CouchbaseTemplate couchbaseTemplate;
    private final String SCOPE = "CORE";
    private final String COLLECTION = "USER";
    public UserRepositoryTemplate(CouchbaseTemplate couchbaseTemplate) {
        this.couchbaseTemplate = couchbaseTemplate;
    }

    public User findByUserId(String userId) {
        ExecutableFindByIdOperation.ExecutableFindById<User> byId = this.couchbaseTemplate.findById(User.class);
        return byId.one(userId);
    }

    public List<User> findAllUsers() {
        return this.couchbaseTemplate.findByQuery(User.class).inScope(SCOPE).inCollection(COLLECTION).all();
    }
}
