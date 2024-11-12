package edu.learn.learn_couchbase.repositories;

import edu.learn.learn_couchbase.entities.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import java.util.Optional;


public interface UserRepository extends CouchbaseRepository<User, String> {

	Optional<User> findByEmailAndMobNo(String email, String mobNo);

}