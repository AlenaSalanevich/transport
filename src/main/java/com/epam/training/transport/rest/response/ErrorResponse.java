package com.epam.training.transport.rest.response;

public class ErrorResponse {

    private String message;

    public ErrorResponse(){
    }

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

