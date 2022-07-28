package com.sabrysolutions.voyager.backend.validators;


import com.sabrysolutions.voyager.backend.models.Profile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        Profile user = (Profile) obj;
        return true /*user.getPassword().equals(user.getMatchingPassword())*/;
    }
}