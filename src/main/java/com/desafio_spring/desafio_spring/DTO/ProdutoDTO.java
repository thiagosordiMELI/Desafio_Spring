package com.desafio_spring.desafio_spring.DTO;

import com.desafio_spring.desafio_spring.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {
    private long productId;
    private String name;
    private int quantity;

    public ProdutoDTO(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.quantity = product.getQuantity();
    }
}
