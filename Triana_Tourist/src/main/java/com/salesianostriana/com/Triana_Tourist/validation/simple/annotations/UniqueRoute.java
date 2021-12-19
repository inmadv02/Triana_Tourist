package com.salesianostriana.com.Triana_Tourist.validation.simple.annotations;

import com.salesianostriana.com.Triana_Tourist.validation.simple.validators.UniquePOIValidator;
import com.salesianostriana.com.Triana_Tourist.validation.simple.validators.UniqueRouteValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UniqueRouteValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueRoute {

    String message() default "Ya existe una ruta con ese nombre";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
