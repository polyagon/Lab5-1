package org.example.MyStream.fileStream;

import org.example.MyStream.InputHandler;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileInputHandler implements InputHandler {

    private FileReader file = null;
    protected Scanner input = null;

    public  FileInputHandler(String path)  {
        try {
            file = new FileReader(path);
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден");
        }
    }

    @Override
    public String get()  {
        String line = "";
        //if(input == null) System.out.println("Файл не определен");
       // else line = input.nextLine();
        return input.nextLine();
    }

    @Override
    public boolean hasNextLine() {
       // if(input == null) System.out.println("Файл не определен");
       // else return input.hasNextLine();
        return input.hasNextLine();
    }

    @Override
    public void close() {
        if(input != null) input.close();
    }





}
