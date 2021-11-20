package com.luxoft.oleksandr_shevchenko.web_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private static int portNumber;
    private static String webAppPath;
    private static String request;


    static void setPort(int port) {
        portNumber = port;
    }

    static void setWebAppPath(String path) {
        webAppPath = path;
    }

    private static String extractPath() {
        String[] subStr = request.split(" ");
        return webAppPath + subStr[1];
    }

    private static String response() throws IOException {
        File contentPath = new File(extractPath());
        InputStream inputStream = new FileInputStream(extractPath());
        int fileLength = (int)contentPath.length();
        byte[] content = new byte[fileLength];
        inputStream.read(content);
        String file = new String(content);
        return file;
    }

    static void start() throws IOException {
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(3000);
                 Socket socket = serverSocket.accept();
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
            ) {
                int count = 0;
                while (true) {
                    String messageFromClient = bufferedReader.readLine();
                    count++;

                    if (count == 1) {
                        request = messageFromClient;
                    }
                    if (messageFromClient.equals("")) {
                        break;
                    }
                }

                bufferedWriter.write("HTTP/1.1 200 OK");
                bufferedWriter.newLine();
                bufferedWriter.newLine();
                bufferedWriter.write(response());
                
                System.out.println(extractPath());

            }
        }
    }
}
