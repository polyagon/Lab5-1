package org.example.MyStream.Exceptions;

import java.io.IOException;

public class LargeFileException extends IOException {
    public LargeFileException(){
        super("Файл слишком большой!");
    }
}