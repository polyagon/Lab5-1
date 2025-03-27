package org.example.Tools.Validators;

public interface Validatable {
    <T> boolean validate(T value) throws IllegalArgumentException;
    Validatable getInstance();


}