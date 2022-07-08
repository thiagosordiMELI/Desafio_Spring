package com.desafio_spring.desafio_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
/** DTO de requisição para compra
 * @version 1.0
 * @since 1.0
 */
public class PurchaseProductRequestDto {
    private UUID id;
    private int quantity;
}
