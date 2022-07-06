package com.desafio_spring.desafio_spring.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {
    private long productId;
    private String name;
    private int quantity;
}
