package edu.learn.couchbase.config.db;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableCouchbaseRepositories(basePackages = {"edu.learn.couchbase.repositories"})
@EnableTransactionManagement
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {

    @Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "Administrator";
    }

    @Override
    public String getPassword() {
        return "Password1";
    }

    @Override
    public String getBucketName() {
        return "crud_apis";
    }
}