package org.example.MyCommands.Excaption;

import java.io.IOException;

public class InvalidFieldValue extends IOException {
    public InvalidFieldValue(String className, String param){
        super(className +   ": введенное значение " + param + " некорректно");
    }
}