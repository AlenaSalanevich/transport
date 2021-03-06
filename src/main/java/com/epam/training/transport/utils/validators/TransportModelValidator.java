package com.epam.training.transport.utils.validators;

import com.epam.training.transport.rest.models.TransportModel;
import com.epam.training.transport.service.exceptions.ErrorCode;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Alena_Salanevich
 */

public class TransportModelValidator implements Validator {
    @Override
    public boolean supports(final Class<?> clazz) {
        if (clazz == null) {
            return false;
        }
        return TransportModel.class.isAssignableFrom(clazz);

    }

    @Override
    public void validate(final Object target, final Errors errors) {
        final TransportModel toValidate = TransportModel.class.cast(target);
        final String trim =
                toValidate.getRegistrationNumber()
                        .trim();
        if (trim.isEmpty()) {
            errors.rejectValue("registrationNumber", ErrorCode.REQUIRED_FIELD.toString(), "Name could not contain empty spaces.");
        }
    }
}
