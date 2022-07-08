package com.desafio_spring.desafio_spring.exception;

/** Exception de Cliente já existente
 * @version 1.0
 * @since 1.0
 */
public class CustomerAlreadyExistsException extends RuntimeException {
    public CustomerAlreadyExistsException() {
        super("Cliente já existe");
    }
}
