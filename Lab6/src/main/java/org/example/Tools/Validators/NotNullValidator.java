package org.example.Tools.Validators;

public class NotNullValidator implements Validatable{
    private static NotNullValidator instance;

    public <T> boolean validate(T value) throws IllegalArgumentException{
        if(value == null) {
            throw new IllegalArgumentException("Значение не может быть null");
        }
        return true;
    }

    public NotNullValidator getInstance() {
        if(instance == null) {
            instance = new NotNullValidator();
        }
        return instance;
    }
}