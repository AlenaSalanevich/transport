package com.epam.training.transport.utils.validators;

import com.epam.training.transport.rest.models.PointModel;

import com.epam.training.transport.service.exceptions.ErrorCode;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Alena_Salanevich
 */

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
            errors.rejectValue("name", ErrorCode.REQUIRED_FIELD.toString(), "Name could not contain only empty spaces.");
        }
    }
}
