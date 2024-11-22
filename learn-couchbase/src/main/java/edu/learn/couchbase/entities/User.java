package edu.learn.couchbase.entities;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.*;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;
import org.springframework.data.couchbase.core.query.N1qlJoin;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Scope;

import java.util.Date;
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

    @CreatedBy
    private String creator;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private Date lastModification;

    @CreatedDate
    private Date creationDate;

    @Version
    private long version;

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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModification() {
        return lastModification;
    }

    public void setLastModification(Date lastModification) {
        this.lastModification = lastModification;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("email='" + email + "'")
                .add("mobNo='" + mobNo + "'")
                .add("password='" + password + "'")
                .add("address=" + address)
                .add("creator='" + creator + "'")
                .add("lastModifiedBy='" + lastModifiedBy + "'")
                .add("lastModification=" + lastModification)
                .add("creationDate=" + creationDate)
                .add("version=" + version)
                .toString();
    }
}