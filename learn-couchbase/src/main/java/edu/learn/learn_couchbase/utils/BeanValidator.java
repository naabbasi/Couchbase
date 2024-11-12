package edu.learn.learn_couchbase.utils;

import edu.learn.learn_couchbase.entities.User;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Set;

@Component
public class BeanValidator {

    public Validator getValidator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

    public ArrayList<String> userValidate(User user) {
        ArrayList<String> arrayList = new ArrayList<>();
        Set<ConstraintViolation<User>> constraintViolations = getValidator().validate(user);
        for (ConstraintViolation<User> constraintViolation : constraintViolations) {
            if (constraintViolation.getPropertyPath().toString().equals("name")) {
                arrayList.add(constraintViolation.getMessage());
            }
            if (constraintViolation.getPropertyPath().toString().equals("email")) {
                arrayList.add(constraintViolation.getMessage());
            }
            if (constraintViolation.getPropertyPath().toString().equals("mobNo")) {
                arrayList.add(constraintViolation.getMessage());
            }
            if (constraintViolation.getPropertyPath().toString().equals("password")) {
                arrayList.add(constraintViolation.getMessage());
            }
        }
        return arrayList;
    }
}