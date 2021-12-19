package com.salesianostriana.com.Triana_Tourist.validation.simple.validators;

import com.salesianostriana.com.Triana_Tourist.repositories.CategoryRepository;
import com.salesianostriana.com.Triana_Tourist.validation.simple.annotations.UniqueCategory;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RequiredArgsConstructor
public class UniqueCategoryValidator implements ConstraintValidator<UniqueCategory, String> {

    private final CategoryRepository repository;

    @Override
    public void initialize(UniqueCategory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsByName(s);
    }
}
