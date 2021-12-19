package com.salesianostriana.com.Triana_Tourist.validation.multiple.validators;

import com.salesianostriana.com.Triana_Tourist.validation.multiple.annotations.NotRepeatedPhotos;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotRepeatedPhotosValidator implements ConstraintValidator<NotRepeatedPhotos, Object> {

    String photoUrl1, photoUrl2, photoUrl3;

    @Override
    public void initialize(NotRepeatedPhotos constraintAnnotation) {
        this.photoUrl1 = constraintAnnotation.photoUrl1();
        this.photoUrl2 = constraintAnnotation.photoUrl2();
        this.photoUrl3 = constraintAnnotation.photoUrl3();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        Object p1 = PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(photoUrl1);
        Object p2 = PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(photoUrl2);
        Object p3 = PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(photoUrl2);

        if(p1.equals(p2) || p1.equals(p3) || p2.equals(p3) ){
            return false;
        }

        return true;
    }
}
