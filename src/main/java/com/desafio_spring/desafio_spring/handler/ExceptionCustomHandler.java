package com.desafio_spring.desafio_spring.handler;

import com.desafio_spring.desafio_spring.exception.ExceptionCustom;
import com.desafio_spring.desafio_spring.exception.ExceptionCustomDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionCustomHandler {

    @ExceptionHandler(ExceptionCustom.class)
    public ResponseEntity<ExceptionCustomDetails> handlerNotFoundException(ExceptionCustom ex) {
        return new ResponseEntity<>(
                ExceptionCustomDetails.builder()
                        .title("Not found")
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity invalidProductHandler(ConstraintViolationException ex) {
        return new ResponseEntity<>(
                ExceptionCustomDetails.builder()
                        .title("Invalid Product")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(ex.getMessage().replace(", ", " | "))
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity badResquestHandler(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(
                ExceptionCustomDetails.builder()
                        .title("Bad request")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(Exception ex) {
        return new ResponseEntity<>(
                ExceptionCustomDetails.builder()
                        .title("Unknown error")
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
