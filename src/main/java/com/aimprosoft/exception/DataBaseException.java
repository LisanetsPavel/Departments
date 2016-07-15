package com.aimprosoft.exception;

/**
 * Created by user on 06.07.16.
 */
public class DataBaseException extends RuntimeException{

    public DataBaseException(String message) {
        super(message);
    }

    public DataBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataBaseException(Throwable cause) {
        super(cause);
    }
}
