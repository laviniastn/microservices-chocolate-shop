package com.microservices.productmanagementservice.validators;


import com.microservices.productmanagementservice.model.Category;
import com.microservices.utils.errorhandler.IncorrectParameterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class CategoryFieldsValidator {

    private static final Log LOGGER = LogFactory.getLog(CategoryFieldsValidator.class);

    public static void validateInsertOrUpdate(Category category) {
        List<String> errors = new ArrayList<>();
        if (category == null) {
            errors.add("Category is null");
            throw new IncorrectParameterException(Category.class.getSimpleName(), errors);
        }

        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            throw new IncorrectParameterException(CategoryFieldsValidator.class.getSimpleName(), errors);
        }
    }
}
