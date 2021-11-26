package com.luxoft.oleksandr_shevchenko.web_server;

import java.io.*;

public class RequestHandler {

    private String request;
    private final String webAppPath;
    private final BufferedReader bufferedReader;
    private final BufferedWriter bufferedWriter;


    RequestHandler(String webAppPath, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        this.webAppPath = webAppPath;
        this.bufferedReader = bufferedReader;
        this.bufferedWriter = bufferedWriter;
    }

    File path() {
        String[] subStr = request.split(" ");
        return new File(webAppPath, subStr[1]);
    }

    void handle() throws IOException {
        try {
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

            String file = ResourceReader.response(path());
            ResponseWriter.access(file, bufferedWriter);

        } catch (ServerException e) {
            ResponseWriter.error(bufferedWriter, e.getStatusCode());
        }
    }

}
