package com.epam.training.transport.rest.controller;

import com.epam.training.transport.rest.response.ErrorResponse;
import com.epam.training.transport.service.exceptions.ServiceException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(value = "com.epam.training.transport.rest.controller")
public class GlobalErrorHandler {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(GlobalErrorHandler.class);

    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public ErrorResponse serviceExceptionHandler(ServiceException e) {
        LOGGER.error(e.getClass().toString());
        return new ErrorResponse("It's "
                + e.getClass().toString() + " " + e.getErrorCode().toString());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String ExceptionHandler(Exception e) {
        LOGGER.error(e);
        return "Unexpected error! Please contact system  admin";
    }

}
