package com.aimprosoft.exception;

import java.util.Map;

/**
 * Created on 06.07.16.
 */
public class ValidationException extends Exception {

    private Map<String, String> errorMap;

    public ValidationException(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }
}
