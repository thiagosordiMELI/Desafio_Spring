package com.desafio_spring.desafio_spring.model;

import com.desafio_spring.desafio_spring.dto.ProductRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private UUID productId = UUID.randomUUID();
    private String name;
    private String category;
    private String brand;
    private double price;
    private int quantity;
    private boolean freeShipping;
    private String prestige;

    /**
     * Construtor Product personalizado
     * @param productRequest produto vindo da requisição
     */
    public Product(ProductRequestDto productRequest) {
        name = productRequest.getName();
        category = productRequest.getCategory();
        brand = productRequest.getBrand();
        price = productRequest.getPrice();
        quantity = productRequest.getQuantity();
        freeShipping = productRequest.isFreeShipping();
        prestige = productRequest.getPrestige();
    }
}
