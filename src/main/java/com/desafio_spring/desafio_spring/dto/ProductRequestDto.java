package com.desafio_spring.desafio_spring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequestDto {
    private static final String notNullMessage = "Campo não pode ser nulo.";
    private static final String valueMessage = "Valor inválido.";

    @NotBlank(message = notNullMessage)
    private String name;

    @NotBlank(message = notNullMessage)
    private String category;

    @NotBlank(message = notNullMessage)
    private String brand;

    @Min(value= 0, message = valueMessage)
    private double price;

    @Min(value= 1, message = valueMessage)
    private int quantity;

    private boolean freeShipping;

    @NotBlank(message = notNullMessage)
    private String prestige;
}
