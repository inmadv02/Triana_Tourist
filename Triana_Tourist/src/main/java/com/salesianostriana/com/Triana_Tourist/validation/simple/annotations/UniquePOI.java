package com.salesianostriana.com.Triana_Tourist.validation.simple.annotations;

import com.salesianostriana.com.Triana_Tourist.validation.simple.validators.UniqueCategoryValidator;
import com.salesianostriana.com.Triana_Tourist.validation.simple.validators.UniquePOIValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UniquePOIValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniquePOI {

    String message() default "Ya existe un punto de interés con ese nombre";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
