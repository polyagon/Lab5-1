package org.example.MyStream.ConsoleHandler;

import org.example.MyStream.InputHandler;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleInput implements InputHandler {
    private final Scanner input = new Scanner(System.in);


    @Override
    public String get() throws IOException {
        try {
            return input.nextLine();
        }catch (Exception e){
            return (e.getMessage());
        }
    }

    @Override
    public boolean hasNextLine() {
        return input.hasNextLine();

    }

    @Override
    public void close() throws IOException{
        input.close();
    }
}
