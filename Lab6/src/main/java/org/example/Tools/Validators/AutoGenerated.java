package org.example.Tools.Validators;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@ValidatableAnnotation(validator = AutoGeneratedValidator.class)
public @interface AutoGenerated {
}