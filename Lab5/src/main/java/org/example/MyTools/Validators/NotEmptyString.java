package org.example.MyTools.Validators;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@ValidatableAnnotation(validator = NotEmptyStringValidator.class)
public @interface NotEmptyString {
}