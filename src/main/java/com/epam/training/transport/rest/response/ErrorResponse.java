package com.epam.training.transport.rest.response;

public class ErrorResponse {

    private String message;

    private String errorCode;

    private String cause;
    private String exceptionClass;

    public ErrorResponse(final String message, final String errorCode, final String cause, final String exceptionClass) {
        this.message = message;
        this.exceptionClass = exceptionClass;
        this.errorCode = errorCode;
        this.cause = cause;
    }

    public ErrorResponse() {
    }

    public ErrorResponse(final String message) {
        this.message = message;
    }

    public ErrorResponse(final String errorCode, final String exceptionClass) {
        this.exceptionClass = exceptionClass;
        this.errorCode = errorCode;
    }

    public ErrorResponse(final String message, final String errorCode, final String exceptionClass) {
        this.message = message;
        this.exceptionClass = exceptionClass;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(final String cause) {
        this.cause = cause;
    }

    public String getExceptionClass() {
        return exceptionClass;
    }

    public void setExceptionClass(final String exceptionClass) {
        this.exceptionClass = exceptionClass;
    }
}
