package com.salesianostriana.com.Triana_Tourist.validation.multiple.validators;

import com.salesianostriana.com.Triana_Tourist.validation.multiple.annotations.NotRepeatedPhotos;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.validation.ObjectError;

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

          for(int i = 0; i< fotos.length; i++) {
              Object field = PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(fotos[i]);
              for (int j = i + 1; j < fotos.length; j++) {
                  Object field2 = PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(fotos[j]);
                  if (field == field2) {
                      return true;
                  }
              }
          }
          return false;
    }
}
