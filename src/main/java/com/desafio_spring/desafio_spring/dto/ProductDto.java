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
public class ProductDto {
    private UUID productId;
    private String name;
    private int quantity;

    public ProductDto(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.quantity = product.getQuantity();
    }
}
