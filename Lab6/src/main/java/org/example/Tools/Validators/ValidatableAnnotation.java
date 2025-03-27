package org.example.Tools.Validators;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatableAnnotation {
    public Class<? extends Validatable> validator();
}