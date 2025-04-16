package com.epam.training.transport.utils.validators;

import com.epam.training.transport.service.exceptions.ErrorCode;
import com.epam.training.transport.service.exceptions.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Base validator class that provides common validation functionality
 */
public abstract class BaseModelValidator<T> {
    
    protected List<String> errors;

    protected BaseModelValidator() {
        this.errors = new ArrayList<>();
    }

    /**
     * Validates the model and throws ServiceException if validation fails
     * @param model the model to validate
     * @throws ServiceException if validation fails
     */
    public void validate(T model) {
        errors.clear();
        doValidate(model);
        if (!errors.isEmpty()) {
            throw new ServiceException(ErrorCode.VALIDATION_ERROR, String.join(", ", errors));
        }
    }

    /**
     * Template method that should be implemented by concrete validators
     * @param model the model to validate
     */
    protected abstract void doValidate(T model);

    /**
     * Validates a field using a predicate
     * @param value the value to validate
     * @param predicate the validation predicate
     * @param errorMessage the error message if validation fails
     */
    protected <V> void validateField(V value, Predicate<V> predicate, String errorMessage) {
        if (!predicate.test(value)) {
            errors.add(errorMessage);
        }
    }

    /**
     * Validates that a string field is not empty
     * @param value the string to validate
     * @param fieldName the name of the field for the error message
     */
    protected void validateNotEmpty(String value, String fieldName) {
        validateField(value, 
            v -> v != null && !v.trim().isEmpty(),
            fieldName + " cannot be empty");
    }

    /**
     * Validates that a number is positive
     * @param value the number to validate
     * @param fieldName the name of the field for the error message
     */
    protected void validatePositive(Number value, String fieldName) {
        validateField(value,
            v -> v != null && v.doubleValue() > 0,
            fieldName + " must be positive");
    }

    /**
     * Validates that an object is not null
     * @param value the object to validate
     * @param fieldName the name of the field for the error message
     */
    protected void validateNotNull(Object value, String fieldName) {
        validateField(value,
            v -> v != null,
            fieldName + " cannot be null");
    }
}