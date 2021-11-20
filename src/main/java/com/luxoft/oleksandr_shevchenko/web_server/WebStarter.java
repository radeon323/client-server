package com.luxoft.oleksandr_shevchenko.web_server;

import java.io.IOException;

public class WebStarter {
    public static void main(String[] args) throws IOException {
        WebServer server = new WebServer();
        server.setPort(3000);
        server.setWebAppPath("src/main/resources/webapp");
        server.start();

    }
}
