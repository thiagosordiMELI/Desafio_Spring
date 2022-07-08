package com.desafio_spring.desafio_spring.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
/** Exception de parâmetros inválidos passados com detalhes para retorno
 * @version 1.0
 * @since 1.0
 */
public class ParamInvalidExceptionDetails {
    private String title;
    private int status;
    private String message;
    private LocalDateTime timestamp;
}
