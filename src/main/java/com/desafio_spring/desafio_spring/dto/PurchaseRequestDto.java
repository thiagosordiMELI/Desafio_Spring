package com.desafio_spring.desafio_spring.dto;

import com.desafio_spring.desafio_spring.model.PurchaseProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/** DTO de requisição para realizar a compra
 * @version 1.0
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequestDto {
    private UUID customerId;
    private List<PurchaseProduct> products;
}
