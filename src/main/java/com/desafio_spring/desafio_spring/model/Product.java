package com.desafio_spring.desafio_spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private static final String notNullMessage = "Campo não pode ser nulo.";
    private static final String valueMessage = "Valor inválido.";

    private UUID productId = UUID.randomUUID();

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
