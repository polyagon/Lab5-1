package org.example.Tools.Validators;

public class AutoGeneratedValidator implements Validatable {
    private static AutoGeneratedValidator instance;

    public <T> boolean validate(T value) throws IllegalArgumentException {
        return true;
    }

    public AutoGeneratedValidator getInstance() {
        if(instance == null) {
            instance = new AutoGeneratedValidator();
        }
        return instance;
    }
}