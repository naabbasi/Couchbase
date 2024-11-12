package edu.learn.learn_couchbase.entities;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class User {

	@Id
	private String id = UUID.randomUUID().toString();

	@NotEmpty(message = "Name must not be empty")
	private String name;
	@NotEmpty(message = "Email must not be empty")
	private String email;
	@NotEmpty(message = "Mobile No must not be empty")
	private String mobNo;
	@NotEmpty(message = "Password must not be empty")
	private String password;

	public User() {
	}

	public User(String id, String name, String email, String mobNo, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobNo = mobNo;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}