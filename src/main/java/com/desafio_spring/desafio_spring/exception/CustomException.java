package com.desafio_spring.desafio_spring.exception;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
