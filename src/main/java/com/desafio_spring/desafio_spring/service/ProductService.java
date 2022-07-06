package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.DTO.ProdutoDTO;
import com.desafio_spring.desafio_spring.model.Product;

import java.util.List;

public interface ProductService {
    List<ProdutoDTO> saveList(List<Product> list);
}
