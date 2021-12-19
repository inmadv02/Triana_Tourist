package com.salesianostriana.com.Triana_Tourist.validation.simple.validators;

import com.salesianostriana.com.Triana_Tourist.repositories.POIRepository;
import com.salesianostriana.com.Triana_Tourist.validation.simple.annotations.UniquePOI;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniquePOIValidator implements ConstraintValidator<UniquePOI, String> {

    private final POIRepository repository;

    @Override
    public void initialize(UniquePOI constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsByName(s);
    }
}
