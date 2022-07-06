package com.desafio_spring.desafio_spring.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequestDto {
    private long productId;
    private String name;
    private String brand;
    private int quantity;
}
