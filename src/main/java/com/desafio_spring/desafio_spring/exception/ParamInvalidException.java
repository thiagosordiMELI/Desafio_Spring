package com.desafio_spring.desafio_spring.exception;

public class ParamInvalidException extends RuntimeException {
    public ParamInvalidException(String message) {
        super(message);
    }
}
