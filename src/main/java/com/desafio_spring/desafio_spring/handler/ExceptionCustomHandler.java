package com.desafio_spring.desafio_spring.handler;

import com.desafio_spring.desafio_spring.exception.ExceptionCustom;
import com.desafio_spring.desafio_spring.exception.ExceptionCustomDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

}
