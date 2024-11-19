package edu.learn.couchbase.repositories;

import edu.learn.couchbase.entities.Address;
import org.springframework.data.couchbase.repository.CouchbaseRepository;


public interface AddressRepository extends CouchbaseRepository<Address, String> {
}