package org.example.MyStream.Exceptions;

public class UndefinedFile extends Exception {
    public UndefinedFile() {
        super("Файл не определен");
    }
}
