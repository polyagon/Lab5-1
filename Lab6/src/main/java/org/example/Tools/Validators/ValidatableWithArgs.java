package org.example.Tools.Validators;

public interface ValidatableWithArgs extends Validatable{
    Validatable getInstance(String value);
}