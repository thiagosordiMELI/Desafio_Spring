package com.desafio_spring.desafio_spring.dto;

import com.desafio_spring.desafio_spring.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseResponseDto {
    private UUID id;
    private List<Product> products;
    private double total;
}
