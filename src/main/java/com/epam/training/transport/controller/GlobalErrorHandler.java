package com.epam.training.transport.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice(value = "com.epam.training.transport.controller")
public class GlobalErrorHandler {
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String exceptionHandler() {
        return "It is DataIntegrityViolationException exception! Make sure you try to add (or update) unique/correct data!";
    }
}
