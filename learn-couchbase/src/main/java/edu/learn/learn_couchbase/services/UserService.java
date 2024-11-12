package edu.learn.learn_couchbase.services;

import edu.learn.learn_couchbase.entities.User;
import edu.learn.learn_couchbase.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Object createUser(User reqData) {
		return userRepository.save(reqData);
	}

	public Object getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> findUserById(String id) {
		return userRepository.findById(id);
	}

	public Object getUserById(String id) {
		return userRepository.findById(id);
	}

	public Object updateUser(User reqData, User isData) {
		isData.setName(reqData.getName());
		isData.setEmail(reqData.getEmail());
		isData.setMobNo(reqData.getMobNo());
		isData.setPassword(reqData.getPassword());
		return userRepository.save(isData);
	}

	public Object deleteUserById(String id) {
		userRepository.deleteById(id);
		return null;
	}

	public Optional<User> isDataExist(User reqData) {
		return userRepository.findByEmailAndMobNo(reqData.getEmail(), reqData.getMobNo());
	}
}