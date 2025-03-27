package org.example.MyTools.Validators;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@ValidatableAnnotation(validator = GreaterThenValidator.class)
public @interface GreaterThen {
    public String value() default "0";
}