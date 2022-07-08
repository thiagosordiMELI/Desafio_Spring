package com.desafio_spring.desafio_spring.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
/** Exception genérica com detalhes para retorno
 * @version 1.0
 * @since 1.0
 */
public class CustomExceptionDetails {
    private String title;
    private int status;
    private String message;
    private LocalDateTime timestamp;
}
