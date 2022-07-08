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
/** DTO de resposta para inserção/atualização do produto
 * @version 1.0
 * @since 1.0
 */
public class ProductResponseDto {
    private UUID productId;
    private String name;
    private int quantity;

    public ProductResponseDto(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.quantity = product.getQuantity();
    }
}
