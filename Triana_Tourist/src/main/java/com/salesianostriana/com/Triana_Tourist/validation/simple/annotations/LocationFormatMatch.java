package com.salesianostriana.com.Triana_Tourist.validation.simple.annotations;

import com.salesianostriana.com.Triana_Tourist.validation.simple.validators.LocationFormatMatchValidator;
import com.salesianostriana.com.Triana_Tourist.validation.simple.validators.UniqueCategoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = LocationFormatMatchValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LocationFormatMatch {

    String message() default "El formato es incorrecto";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
