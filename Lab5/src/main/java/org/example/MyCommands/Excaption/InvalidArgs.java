package org.example.MyCommands.Excaption;

import java.util.ArrayList;

public class InvalidArgs {

    String message;
    public  InvalidArgs(ArrayList<String> args) {
        StringBuilder sb = new StringBuilder("Неожиднный список аргументов: Введеные аргументы ");
        for (String arg : args) {
            sb.append(arg).append(" ");
        }
        sb.append(" являются неожиданными");
        message = (sb.toString());
    }
    public String getMessage() {
        return message;
    }
}
