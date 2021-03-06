package com.desafio_spring.desafio_spring.dto;

import com.desafio_spring.desafio_spring.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/** DTO de resposta representando a compra
 * @version 1.0
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseResponseDto {
    private UUID id;
    private Customer customer;
    private List<PurchaseProductResponseDto> products;
    private double total;
}
