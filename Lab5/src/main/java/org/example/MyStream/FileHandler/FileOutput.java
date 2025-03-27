package org.example.MyStream.FileHandler;

import org.example.MyStream.OutputHandler;

import java.io.*;

public class FileOutput implements OutputHandler {

    private OutputStream file = null;
    private OutputStreamWriter output = null;

    public FileOutput(String path) {
        try {
            // Проверяем, существует ли файл, если нет - создаем его
            File outputFile = new File(path);
            if (!outputFile.isFile()) {
                outputFile.createNewFile();
            }

            file = new FileOutputStream(path);  // Открываем поток для записи
            output = new OutputStreamWriter(file);  // Создаем OutputStreamWriter для записи в файл
            output.write("");  // Очищаем содержимое файла, если нужно
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void print(String message) {
        if (output == null || file == null) {
            System.out.println("Файл не определен");
        } else {
            try {
                output.write(message);  // Записываем сообщение в файл
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void println(String message) {
        print(message + "\n");  // Добавляем новую строку и передаем в метод print
    }

    @Override
    public void close() throws IOException {
        if (output != null) {
            output.close();  // Закрываем OutputStreamWriter
        }
    }
}
