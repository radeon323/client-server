package com.luxoft.oleksandr_shevchenko.web_server;

import java.io.*;

public class ResourceReader {

    private final String webAppPath;

    public ResourceReader(String webAppPath) {
        this.webAppPath = webAppPath;
    }


    static String response(File path) throws IOException {
        try {
            InputStream inputStream = new FileInputStream(path);
            int fileLength = (int)path.length();
            byte[] content = new byte[fileLength];
            inputStream.read(content);
            String file = new String(content);
            return file;
        } catch (FileNotFoundException e) {
            throw new ServerException(StatusCode.NOT_FOUND);
        }

    }
}
