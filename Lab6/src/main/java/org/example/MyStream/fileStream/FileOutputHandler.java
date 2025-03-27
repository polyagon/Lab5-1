package org.example.MyStream.fileStream;

import org.example.MyStream.OutputHandler;

import java.io.*;

public class FileOutputHandler  implements OutputHandler {

    private OutputStream file = null;
    private Writer output = null;

    public FileOutputHandler(String path) {
        try{
            if(! new File(path).isFile()) new File(path).createNewFile();
            file = new FileOutputStream(path);
            output = new OutputStreamWriter(file);
            output.write("");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void print(String message){
            if (output == null || file == null) {System.out.println("Файл не определен");
            }
            else{
                try {

                    output.write(message);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }


    }

    @Override
    public void println(String message){
        print(message + "\n");

    }

    @Override
    public void close() throws IOException{
        output.close();
    }

}
