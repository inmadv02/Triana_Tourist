package com.salesianostriana.com.Triana_Tourist.validation.simple.validators;

import com.salesianostriana.com.Triana_Tourist.validation.simple.annotations.PhotoUrlFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhotoFormatValidator implements ConstraintValidator<PhotoUrlFormat, String> {


    @Override
    public void initialize(PhotoUrlFormat constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        String pattern = "http(s?)://([\\w-]+\\.)+[\\w-]+(/[\\w- ./]*)+\\.(?:[gG][iI][fF]|[jJ][pP][gG]|[jJ][pP][eE][gG]|[pP][nN][gG]|[bB][mM][pP])";;
        Pattern patron = Pattern.compile(pattern);
        Matcher coincide = patron.matcher(s);

        return coincide.find();
    }
}
