package com.epam.training.transport.controller.response;

public class ErrorResponse {

    private String message;
    private String url;

    public ErrorResponse(final String message, final String url) {
        this.message = message;
        this.url = url;
    }
    public ErrorResponse(){

    }

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getUrl() {
        return url;
    }
}

