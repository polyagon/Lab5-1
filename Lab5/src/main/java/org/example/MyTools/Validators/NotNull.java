package org.example.MyTools.Validators;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@ValidatableAnnotation(validator = NotNullValidator.class)
public @interface NotNull {
}