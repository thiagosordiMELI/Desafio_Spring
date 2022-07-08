package com.desafio_spring.desafio_spring.exception;

/** Exception de parâmetros inválidos passados
 * @version 1.0
 * @since 1.0
 */
public class ParamInvalidException extends RuntimeException {
    public ParamInvalidException(String message) {
        super(message);
    }
}
