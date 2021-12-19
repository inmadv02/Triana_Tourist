package com.salesianostriana.com.Triana_Tourist.validation.simple.validators;

import com.salesianostriana.com.Triana_Tourist.validation.simple.annotations.LocationFormatMatch;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocationFormatMatchValidator implements ConstraintValidator<LocationFormatMatch, String> {

    @Override
    public void initialize(LocationFormatMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        String cadena = "^([-+]?\\d{1,2}[.]\\d+),\\s*([-+]?\\d{1,3}[.]\\d+)$";
        Pattern patron = Pattern.compile(cadena);

        Matcher coincide = patron.matcher(s);

        return coincide.find();
    }
}
