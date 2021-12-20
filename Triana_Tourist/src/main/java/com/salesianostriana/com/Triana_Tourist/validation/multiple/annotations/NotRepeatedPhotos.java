package com.salesianostriana.com.Triana_Tourist.validation.multiple.annotations;

import com.salesianostriana.com.Triana_Tourist.validation.multiple.validators.NotRepeatedPhotosValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NotRepeatedPhotosValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotRepeatedPhotos {


    String message() default "Las fotos no pueden ser iguales";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] fields();


}