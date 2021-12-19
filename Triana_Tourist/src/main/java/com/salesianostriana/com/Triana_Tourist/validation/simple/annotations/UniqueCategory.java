package com.salesianostriana.com.Triana_Tourist.validation.simple.annotations;

import com.salesianostriana.com.Triana_Tourist.validation.simple.validators.UniqueCategoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UniqueCategoryValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueCategory {

    String message() default "Ya existe una categoría con ese nombre";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
