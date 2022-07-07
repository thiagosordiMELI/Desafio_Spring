package com.desafio_spring.desafio_spring.dto;

import com.desafio_spring.desafio_spring.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseProductResponseDto {
    private UUID productId;
    private String name;
    private String category;
    private String brand;
    private double price;
    private int quantityPurchased;
    private boolean freeShipping;
    private String prestige;


    public PurchaseProductResponseDto(Product product, int quantityPurchased){
        this.productId = product.getProductId();
        this.name = product.getName();
        this.category = product.getCategory();
        this.brand = product.getBrand();
        this.price = product.getPrice();
        this.quantityPurchased = quantityPurchased;
        this.freeShipping = product.isFreeShipping();
        this.prestige = product.getPrestige();
    }
}
