package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {

    public static void main(String[] args) throws IOException {
        int port = 8888;
        ServerSocket ss = new ServerSocket(port);
        Socket client = ss.accept();

        InputStream input = client.getInputStream();
        byte[] message = new byte[10]; // как принимать в буффер сообщение больше (динамически)
        input.read(message);




    }

}
