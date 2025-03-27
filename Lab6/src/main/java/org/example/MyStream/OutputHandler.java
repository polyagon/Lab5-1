package org.example.MyStream;


import java.io.IOException;

public interface OutputHandler {

    void print(String data) ;

    void println(String data)  ;

    default void printErr(String data)  {
        System.out.println("Ошибка: " + data);
    }

    void close() throws IOException;
}
