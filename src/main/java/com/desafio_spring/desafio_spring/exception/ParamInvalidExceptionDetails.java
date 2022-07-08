package com.desafio_spring.desafio_spring.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ParamInvalidExceptionDetails {
    private String title;
    private int status;
    private String message;
    private LocalDateTime timestamp;
}