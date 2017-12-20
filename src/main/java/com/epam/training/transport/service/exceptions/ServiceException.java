package com.epam.training.transport.service.exceptions;

public class ServiceException extends RuntimeException {

    private ErrorCode errorCode;

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

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
