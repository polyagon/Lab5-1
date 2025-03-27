package org.example.MyTools.Validators;

import org.example.MyTools.Converter;

public class GreaterThenValidator implements ValidatableWithArgs{
    private String value;
    public GreaterThenValidator(String value) {
        this.value = value;
    }
    public GreaterThenValidator() {
        this.value = "0";
    }

    public GreaterThenValidator getInstance(String value) {
        return new GreaterThenValidator(value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <U> boolean validate(U value) throws IllegalArgumentException {
        U tmp = (U) Converter.convert(value.getClass(), this.value);

        if(((Comparable<U>)value).compareTo(tmp) <= 0) {
            throw new IllegalArgumentException("Значение должно быть больше " + this.value + " введено " + value);
        }
        return true;
    }

    @Override
    public Validatable getInstance() {
        return new GreaterThenValidator("0");
    }
}