package com.epam.training.transport.utils;

import com.epam.training.transport.rest.params.PointModel;

import com.epam.training.transport.service.exceptions.ErrorCode;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PointModelValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        if (clazz == null) {
            return false;
        }
        return PointModel.class.isAssignableFrom(clazz);

    }

    @Override
    public void validate(Object target, Errors errors) {
        PointModel toValidate = PointModel.class.cast(target);
        String trim =
            toValidate.getName()
                .trim();
        if (trim.isEmpty()) {
            errors.rejectValue("name", ErrorCode.REQUIRED_FIELD.toString(), "Name could not contain empty spaces.");
        }
        if (trim.length() < 3) {
            errors.rejectValue("name", ErrorCode.REQUIRED_FIELD.toString(),
                "Name must contain 3 or more symbols excluding empty spaces.");
        }
    }
}