package com.desafio_spring.desafio_spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class Handler {

    // Mensagens de erro na validacao da model não podem ter víngulas.
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity invalidProductHandler(ConstraintViolationException e) {
        return new ResponseEntity(e.getMessage().replace(", ", "\n"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity badResquestHandler(HttpMessageNotReadableException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(Exception e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
