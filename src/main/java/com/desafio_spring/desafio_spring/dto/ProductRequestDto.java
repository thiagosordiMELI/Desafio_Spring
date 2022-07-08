package com.desafio_spring.desafio_spring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * DTO de requisição para inserir/atualizar produto
 *
 * @version 1.0
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class ProductRequestDto {
    @NotBlank(message = "Campo 'name' não pode ser vazio")
    private String name;

    @NotBlank(message = "Campo 'category' não pode ser vazio")
    private String category;

    @NotBlank(message = "Campo 'brand' não pode ser vazio")
    private String brand;

    @Min(value = 0, message = "Campo 'price' com valor inválido")
    private double price;

    @Min(value = 1, message = "Campo 'quantity' com valor inválido")
    private int quantity;

    private boolean freeShipping;

    @NotBlank(message = "Campo 'prestige' não pode ser vazio")
    private String prestige;
}
