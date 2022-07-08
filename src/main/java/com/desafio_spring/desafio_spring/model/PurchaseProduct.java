package com.desafio_spring.desafio_spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Representa um produto de uma compra
 *
 * @version 1.0
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseProduct {
    private UUID productId;
    private int quantity;
}
