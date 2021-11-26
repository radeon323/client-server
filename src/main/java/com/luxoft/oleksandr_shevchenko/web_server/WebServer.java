package com.luxoft.oleksandr_shevchenko.web_server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private static int portNumber;
    private static String webAppPath;

    static void setPort(int port) {
        portNumber = port;
    }

    static void setWebAppPath(String path) {
        webAppPath = path;
    }

    static void start() throws IOException {
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(3000);
                 Socket socket = serverSocket.accept();
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
            ) {
                RequestHandler requestHandler = new RequestHandler(webAppPath, bufferedReader, bufferedWriter);
                requestHandler.handle();
            }
        }
    }
}
