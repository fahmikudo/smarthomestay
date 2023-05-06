package com.fahmikudo.tritronik.smarthomestay.exception;

public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(String message, String reason) {
        super(message + " " + reason);
    }

}
