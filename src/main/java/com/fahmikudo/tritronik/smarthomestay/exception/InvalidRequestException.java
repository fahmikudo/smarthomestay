package com.fahmikudo.tritronik.smarthomestay.exception;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String message, String reason) {
        super(message + " " + reason);
    }
}
