package com.dh.clinica.exception;

public class BadRequestNewException extends RuntimeException{
    public BadRequestNewException(String message) {
        super(message);
    }
}
