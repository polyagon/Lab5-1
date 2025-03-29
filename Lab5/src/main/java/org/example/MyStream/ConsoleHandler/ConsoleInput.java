package org.example.MyStream.ConsoleHandler;

import org.example.MyStream.InputHandler;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleInput implements InputHandler {
    private Scanner input = new Scanner(System.in);

    private void resetInput(){
        System.out.println("Консоль перезапущена, продолжайте");
        input = new Scanner(System.in);
    }

    public  String promptReadLine(String prompt) throws IOException {
        String input = "";
        while (true) {
            System.out.print(prompt);
            if (hasNextLine()) {
                resetInput();
                continue;
            }
            input = get();
            break;
        }

        return input;
    }





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
