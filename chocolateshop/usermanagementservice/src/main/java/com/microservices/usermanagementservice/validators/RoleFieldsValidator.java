package com.microservices.usermanagementservice.validators;


import com.microservices.usermanagementservice.model.Role;
import com.microservices.utils.errorhandler.IncorrectParameterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class RoleFieldsValidator {

    private static final Log LOGGER = LogFactory.getLog(RoleFieldsValidator.class);

    public static void validateInsertOrUpdate(Role role) {
        List<String> errors = new ArrayList<>();
        if (role == null) {
            errors.add("role is null");
            throw new IncorrectParameterException(Role.class.getSimpleName(), errors);
        }

        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            throw new IncorrectParameterException(RoleFieldsValidator.class.getSimpleName(), errors);
        }
    }
}
