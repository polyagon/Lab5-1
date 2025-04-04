package org.example.Tools.Validators;

public class NotEmptyStringValidator implements Validatable{
    private static NotEmptyStringValidator instance;

    public <T> boolean validate(T value) throws IllegalArgumentException {
        String s;
        try {
            s = (String) value;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Значение не является строкой");
        }
        if(value == null || s.isEmpty() || s.isBlank()) {
            throw new IllegalArgumentException("Значение не может быть пустой строкой");
        }
        return true;
    }

    @Override
    public Validatable getInstance() {
        if (instance == null) {
            instance = new NotEmptyStringValidator();
        }
        return instance;
    }
}