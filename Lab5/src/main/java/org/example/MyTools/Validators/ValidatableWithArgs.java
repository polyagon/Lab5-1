package org.example.MyTools.Validators;

public interface ValidatableWithArgs extends Validatable{
    Validatable getInstance(String value);
}