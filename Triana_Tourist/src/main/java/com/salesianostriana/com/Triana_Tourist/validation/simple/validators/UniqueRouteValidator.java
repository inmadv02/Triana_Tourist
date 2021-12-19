package com.salesianostriana.com.Triana_Tourist.validation.simple.validators;

import com.salesianostriana.com.Triana_Tourist.repositories.RouteRepository;
import com.salesianostriana.com.Triana_Tourist.validation.simple.annotations.UniquePOI;
import com.salesianostriana.com.Triana_Tourist.validation.simple.annotations.UniqueRoute;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueRouteValidator implements ConstraintValidator<UniqueRoute, String> {

    private final RouteRepository repository;

    @Override
    public void initialize(UniqueRoute constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsByName(s);
    }
}
