package org.example.MyStream;

import java.io.IOException;

public interface InputHandler {

    String get() throws IOException;


    boolean hasNextLine() throws IOException;


    void close() throws IOException;
}
