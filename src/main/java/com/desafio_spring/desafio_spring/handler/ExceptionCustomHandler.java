package com.desafio_spring.desafio_spring.handler;

import com.desafio_spring.desafio_spring.exception.*;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionCustomHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomExceptionDetails> handlerNotFoundException(CustomException ex) {
        return new ResponseEntity<>(
                CustomExceptionDetails.builder()
                        .title("Not found")
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ParamInvalidException.class)
    public ResponseEntity paramInvalidException(ParamInvalidException ex) {
        return new ResponseEntity<>(
                CustomExceptionDetails.builder()
                        .title("Invalid parameter")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity invalidProductHandler(ConstraintViolationException ex) {
        return new ResponseEntity<>(
                CustomExceptionDetails.builder()
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
                CustomExceptionDetails.builder()
                        .title("Bad request")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomExceptionDetails> requestBodyInvalidHandler(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(
                CustomExceptionDetails
                        .builder()
                        .title("Invalid Data")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(ex.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining("; ")))
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<CustomExceptionDetails> customerAlreadyExistsExceptionHandler(CustomerAlreadyExistsException ex) {
        return new ResponseEntity<>(
                CustomExceptionDetails.builder()
                        .title("Client already exists")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(Exception ex) {
        return new ResponseEntity<>(
                CustomExceptionDetails.builder()
                        .title("Unknown error")
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({UnsupportedOperationException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity invalidOrderHandler() {
        return new ResponseEntity<>(
                CustomExceptionDetails.builder()
                        .title("Order not supported")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(new Throwable("Ordens suportadas: " +
                                "0: Alfabética crescente | " +
                                "1: Alfabética decrescente | " +
                                "2: Maior a menor preço | " +
                                "3: Menor a maior preço.").getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }

}
