package org.example.MyTools.Validators;

import org.example.MyTools.Converter;

public class StringSizeValidator implements ValidatableWithArgs {
    private String maxLength;

    public StringSizeValidator(String maxLength) {
        this.maxLength = maxLength;
    }

    public StringSizeValidator() {
        this.maxLength = "100";
    }

    public StringSizeValidator getInstance(String maxLength) {
        return new StringSizeValidator(maxLength);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <U> boolean validate(U value) throws IllegalArgumentException {
        if (value instanceof String) {
            String stringValue = (String) value;

            if (stringValue.length() > Integer.valueOf(maxLength)) {
                throw new IllegalArgumentException("Длина строки должна быть не больше " + maxLength + ". Введено: " + stringValue.length());
            }
            return true;
        } else {
            throw new IllegalArgumentException("Ожидалась строка, но получено: " + value.getClass().getSimpleName());
        }
    }

    @Override
    public Validatable getInstance() {
        return new StringSizeValidator("100");
    }
}
