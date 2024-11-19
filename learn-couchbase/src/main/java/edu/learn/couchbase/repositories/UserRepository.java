package edu.learn.couchbase.repositories;

import edu.learn.couchbase.entities.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import java.util.Optional;


public interface UserRepository extends CouchbaseRepository<User, String> {

	Optional<User> findByEmailAndMobNo(String email, String mobNo);

}