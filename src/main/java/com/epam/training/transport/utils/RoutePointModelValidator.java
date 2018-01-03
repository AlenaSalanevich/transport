package com.epam.training.transport.utils;

import com.epam.training.transport.rest.models.RoutePointModel;
import com.epam.training.transport.service.exceptions.ErrorCode;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RoutePointModelValidator implements Validator {
    @Override
    public boolean supports(final Class<?> clazz) {
        if (clazz == null) {
            return false;
        }
        return RoutePointModel.class.isAssignableFrom(clazz);

    }

    @Override
    public void validate(final Object target, final Errors errors) {
        final RoutePointModel toValidate = RoutePointModel.class.cast(target);
        final String trim =
            toValidate.getDepartureTime()
                .trim();
        if (trim.isEmpty()) {
            errors.rejectValue("Departure time", ErrorCode.REQUIRED_FIELD.toString(),
                "Departure time could not contain only empty spaces.");
        }
    }
}
