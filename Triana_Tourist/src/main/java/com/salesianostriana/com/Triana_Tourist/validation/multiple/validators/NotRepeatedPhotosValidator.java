package com.salesianostriana.com.Triana_Tourist.validation.multiple.validators;

import com.salesianostriana.com.Triana_Tourist.validation.multiple.annotations.NotRepeatedPhotos;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class NotRepeatedPhotosValidator implements ConstraintValidator<NotRepeatedPhotos, Object> {

    String[] fotos;

    @Override
    public void initialize(NotRepeatedPhotos constraintAnnotation) {
        this.fotos = constraintAnnotation.fields();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {


       for(int i = 0; i< fotos.length; i++)
           for(int j = 0; j< fotos.length; j++) {
               if (fotos[i] != null && fotos[j] != null) {
                   if (fotos[i].equals(fotos[j])) {
                       return false;
                   }
               }
               return true;
           }
           return true;

    }
}
