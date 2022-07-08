package com.desafio_spring.desafio_spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/** Representa uma compra
 * @version 1.0
 * @since 1.0
 */
public class Purchase {
    private UUID id;
    private List<PurchaseProduct> products;
}
