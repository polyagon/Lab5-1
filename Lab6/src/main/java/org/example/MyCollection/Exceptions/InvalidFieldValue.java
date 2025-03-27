package org.example.MyCollection.Exceptions;

import java.io.IOException;

public class InvalidFieldValue extends IOException {
    public InvalidFieldValue(String className, String param){
          super(className +   ": введенное значение " + param + " некорректно");
    }
}
