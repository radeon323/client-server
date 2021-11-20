package com.luxoft.oleksandr_shevchenko.echo_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws IOException {

        try (Socket socket = new Socket("localhost", 3000);
             InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream();) {


            while (true) {
                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();
                outputStream.write(message.getBytes());

                byte[] buffer = new byte[100];

                int count = inputStream.read(buffer);
                System.out.println(new String(buffer, 0, count));

            }
        }


    }
}
