package com.desafio_spring.desafio_spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private long productId;
    private String name;
    private String category;
    private String brand;
    private double price;
    private int quantity;
    private boolean freeShipping;
    private String prestige;
}
