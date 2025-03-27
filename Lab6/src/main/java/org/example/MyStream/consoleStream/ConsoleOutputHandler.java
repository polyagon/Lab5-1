package org.example.MyStream.consoleStream;


import org.example.MyStream.OutputHandler;

public class ConsoleOutputHandler implements OutputHandler {
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
