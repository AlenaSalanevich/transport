package com.epam.training.transport.rest.controller;

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
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String dataExceptionHandler() {
        LOGGER.error(DataIntegrityViolationException.class.toString());
        return "It's "
               + DataIntegrityViolationException.class.toString()
               + " ! Make sure you try to add (or update) unique/correct data!";
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public String nullPointExceptionHandler() {
        LOGGER.error(NullPointerException.class.toString());
        return "It's "
                + NullPointerException.class.toString()
                + " ! Make sure you try to add (or update) unique/correct data!";
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public String emptyDataExeptionHandler() {
        LOGGER.error(EmptyResultDataAccessException.class.toString());
        return "It's "
                + EmptyResultDataAccessException.class.toString()
                + " ! Make sure you try to add (or update) unique/correct data!";
    }
}
