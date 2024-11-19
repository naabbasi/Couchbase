package edu.learn.couchbase;

import edu.learn.couchbase.entities.Address;
import edu.learn.couchbase.entities.User;
import edu.learn.couchbase.repositories.AddressRepository;
import edu.learn.couchbase.repositories.UserRepository;
import edu.learn.couchbase.repositories.UserRepositoryTemplate;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class LearnCouchbaseApplication {

	@Bean
	ApplicationRunner applicationRunner(UserRepository userRepository, UserRepositoryTemplate userRepositoryTemplate,
										AddressRepository addressRepository) {
		return _ -> {
			User user = new User();
			user.setFirstName("Noman");
			user.setLastName("Ali");
			user.setEmail("nomanali@elm.sa");
			user.setPassword("x");
			user.setMobNo("537270366");
			User savedUser = userRepository.save(user);
			User byUserId = userRepositoryTemplate.findByUserId(savedUser.getId());
			System.out.println(byUserId);

			List<User> allUsers = userRepositoryTemplate.findAllUsers();
			for (User getUser : allUsers) {
				System.out.println(getUser);
			}

			Address address = new Address();
			address.setUserId(byUserId.getId());
			address.setStreetName("Fifa");
			addressRepository.save(address);

			userRepository.deleteById(savedUser.getId());

			Optional<User> byEmailAndMobNo = userRepository.findByEmailAndMobNo(savedUser.getEmail(), savedUser.getMobNo());
			if(byEmailAndMobNo.isPresent()) {
				System.out.println(byEmailAndMobNo.get());
			}

			Optional<Address> addressById = addressRepository.findById(address.getUserId());
			if(addressById.isPresent()){
				System.out.println(addressById.get());
				addressRepository.deleteById(address.getUserId());
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(LearnCouchbaseApplication.class, args);
	}

}
