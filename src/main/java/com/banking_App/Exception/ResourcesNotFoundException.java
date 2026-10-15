package com.banking_App.Exception;

public class ResourcesNotFoundException extends RuntimeException {

    public ResourcesNotFoundException(
            String resourceName,
            String fieldName,
            Object fieldValue) {

        super(resourceName + " not found with "
                + fieldName + " : " + fieldValue);
    }
}