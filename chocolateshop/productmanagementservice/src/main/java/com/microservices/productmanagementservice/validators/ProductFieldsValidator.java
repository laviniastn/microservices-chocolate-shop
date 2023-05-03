package com.microservices.productmanagementservice.validators;

import com.microservices.productmanagementservice.model.Product;
import com.microservices.utils.errorhandler.IncorrectParameterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductFieldsValidator {

    private static final Log LOGGER = LogFactory.getLog(ProductFieldsValidator.class);

    public static void validateInsertOrUpdate(Product product) {
        List<String> errors = new ArrayList<>();
        if (product == null) {
            errors.add("Product is null");
            throw new IncorrectParameterException(Product.class.getSimpleName(), errors);
        }

        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            throw new IncorrectParameterException(ProductFieldsValidator.class.getSimpleName(), errors);
        }
    }
}

