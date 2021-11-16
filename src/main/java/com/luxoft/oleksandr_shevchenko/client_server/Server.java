package com.luxoft.oleksandr_shevchenko.client_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(3000);
             Socket socket = serverSocket.accept();
             OutputStream outputStream = socket.getOutputStream();
             InputStream inputStream = socket.getInputStream();) {

            while (true) {
                StringBuilder stringBuilder = new StringBuilder();
                byte[] buffer = new byte[100];
                int count = inputStream.read(buffer);
                String message = new String(buffer, 0, count);

                stringBuilder.append("echo: ");
                stringBuilder.append(message);
                String msgWithEcho = stringBuilder.toString();

                outputStream.write(msgWithEcho.getBytes());

            }

        }


    }
}

