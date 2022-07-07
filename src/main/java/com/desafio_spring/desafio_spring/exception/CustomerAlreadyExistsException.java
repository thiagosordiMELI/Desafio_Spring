package com.desafio_spring.desafio_spring.exception;

public class CustomerAlreadyExistsException extends RuntimeException {
    public CustomerAlreadyExistsException() {
        super("Cliente já existe");
    }
}
