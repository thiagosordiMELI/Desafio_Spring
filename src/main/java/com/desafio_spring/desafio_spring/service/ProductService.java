package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.ProductRequestDto;
import com.desafio_spring.desafio_spring.dto.ProductDto;

import java.util.List;

public interface ProductService {
    /**
     * Metódo do Service que cuida da lógica de salvar os produtos e gerar o DTO de saída.
     * @param productList lista de objetos ProductRequestDto
     * @return Lista de objetos ProductDto.
     */
    List<ProductDto> saveProducts(List<ProductRequestDto> productList);
    /**
     * Metódo do Service que cuida da lógica de pegar todos os produtos salvos.
     * @return Lista de objetos ProductDto.
     */
    List<ProductDto> getAllProducts();
}
