package edu.learn.couchbase.entities;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;
import org.springframework.data.couchbase.core.query.N1qlJoin;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Scope;

import java.util.StringJoiner;
import java.util.UUID;

@Scope("CORE")
@Collection("USER")
@Document
public class User {

    @Id
	@GeneratedValue(strategy = GenerationStrategy.USE_ATTRIBUTES, delimiter = "#")
	//@GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String id = UUID.randomUUID().toString();

    @NotEmpty(message = "First name must not be empty")
    @Field
    private String firstName;
    @NotEmpty(message = "Last name must not be empty")
    @Field
    private String lastName;
    @IdAttribute
    @NotEmpty(message = "Email must not be empty")
    @Field
    private String email;
    @NotEmpty(message = "Mobile No must not be empty")
    @Field
    private String mobNo;
    @NotEmpty(message = "Password must not be empty")
    @Field
    private String password;

    @N1qlJoin(on = "lks.id=rks.userId")
    Address address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("name='" + firstName + "'")
                .add("email='" + email + "'")
                .add("mobNo='" + mobNo + "'")
                .add("password='" + password + "'")
                .toString();
    }
}