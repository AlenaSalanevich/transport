package com.epam.training.transport.service.exceptions;

/**
 * @author Alena_Salanevich
 */

public class ServiceException extends RuntimeException {

    private ErrorCode errorCode;
    private String message;

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ServiceException(final ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ServiceException(final Throwable cause) {
        this(ErrorCode.UNKNOWN, cause);
    }

    public ServiceException(final ErrorCode errorCode, final Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }
    public ServiceException(final ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ServiceException(final Throwable cause, String message) {
        this(ErrorCode.UNKNOWN, cause);
        this.message=message;
    }

    public ServiceException(final ErrorCode errorCode, final Throwable cause, String message) {
        super(cause);
        this.errorCode = errorCode;
        this.message= message;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
