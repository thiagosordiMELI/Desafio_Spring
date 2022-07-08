package com.desafio_spring.desafio_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/** DTO de resposta para valor total do carrinho
 * @version 1.0
 * @since 1.0
 */
public class CartResponseDto {
    private double total;
}
