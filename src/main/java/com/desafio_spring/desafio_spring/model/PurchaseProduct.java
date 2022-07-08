package com.desafio_spring.desafio_spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
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

    @Min(value = 1, message = "Campo 'quantity' tem que ser maior do que zero.")
    private int quantity;
}
