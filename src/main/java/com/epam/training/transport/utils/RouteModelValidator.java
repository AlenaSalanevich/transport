package com.epam.training.transport.utils;

import com.epam.training.transport.rest.models.RouteModel;
import com.epam.training.transport.service.exceptions.ErrorCode;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Alena_Salanevich
 */

public class RouteModelValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        if (clazz == null) {
            return false;
        }
        return RouteModel.class.isAssignableFrom(clazz);

    }

    @Override
    public void validate(final Object target, final Errors errors) {

        final RouteModel toValidate = RouteModel.class.cast(target);
        final String trim =
            toValidate.getNumber()
                .trim();
        if (trim.isEmpty()) {
            errors.rejectValue("number", ErrorCode.REQUIRED_FIELD.toString(), "Number could not contain only empty spaces.");
        }
    }

}
