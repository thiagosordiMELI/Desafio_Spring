package com.desafio_spring.desafio_spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExceptionCustom extends RuntimeException {
    public ExceptionCustom(String message) {
        super(message);
    }
}
