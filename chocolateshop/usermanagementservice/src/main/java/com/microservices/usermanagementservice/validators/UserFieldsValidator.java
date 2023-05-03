package com.microservices.usermanagementservice.validators;

import com.microservices.usermanagementservice.model.User;
import com.microservices.utils.errorhandler.IncorrectParameterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class UserFieldsValidator {

    private static final Log LOGGER = LogFactory.getLog(UserFieldsValidator.class);

    public static void validateInsertOrUpdate(User user) {
        List<String> errors = new ArrayList<>();
        if (user == null) {
            errors.add("user is null");
            throw new IncorrectParameterException(User.class.getSimpleName(), errors);
        }

        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            throw new IncorrectParameterException(UserFieldsValidator.class.getSimpleName(), errors);
        }
    }
}

