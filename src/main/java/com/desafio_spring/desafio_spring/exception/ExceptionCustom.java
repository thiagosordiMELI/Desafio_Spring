package com.desafio_spring.desafio_spring.exception;

/** Exception genérica, mas com status 404 por default
 * @version 1.0
 * @since 1.0
 */
public class ExceptionCustom extends RuntimeException {
    public ExceptionCustom(String message) {
        super(message);
    }
}
