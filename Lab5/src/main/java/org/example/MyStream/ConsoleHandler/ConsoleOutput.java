package org.example.MyStream.ConsoleHandler;

import org.example.MyStream.OutputHandler;

public class ConsoleOutput implements OutputHandler {
    @Override
    public void print(String data) {
        System.out.print(data);
    }

    @Override
    public void println(String data) {
        System.out.println(data);
    }
    @Override
    public void close() {
        ;
    }
}
