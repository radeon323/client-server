package com.luxoft.oleksandr_shevchenko.web_server;

public class ServerException extends RuntimeException {
    private StatusCode statusCode;

    public ServerException(String message, Throwable cause, StatusCode statusCode) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    public ServerException(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }


}
