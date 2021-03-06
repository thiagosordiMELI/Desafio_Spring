package com.desafio_spring.desafio_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/** DTO de resposta para valor total do carrinho
 * @version 1.0
 * @since 1.0
 */
@Data
@AllArgsConstructor
public class CartResponseDto {
    private double total;
}
