package org.example.MyTools.Validators;

import java.lang.annotation.*;
import java.util.ArrayList;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@ValidatableAnnotation(validator = GreaterThenValidator.class)
public @interface StringSize {
    public String value() default ("100");
}