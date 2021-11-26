package com.luxoft.oleksandr_shevchenko.web_server;

import java.io.BufferedWriter;
import java.io.IOException;

public class ResponseWriter {

    static void access(String content, BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write("HTTP/1.1 200 OK");
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        bufferedWriter.write(content);
    }

     public static void error(BufferedWriter bufferedWriter, StatusCode statusCode) throws IOException {
         bufferedWriter.write("HTTP/1.1 " + statusCode.getCode());
         bufferedWriter.newLine();
         bufferedWriter.newLine();
         bufferedWriter.write(statusCode.getCode() + " " + statusCode.getStatusText());
    }
}
