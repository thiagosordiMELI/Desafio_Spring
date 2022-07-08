package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.ProductResponseDto;
import com.desafio_spring.desafio_spring.dto.ProductRequestDto;
import com.desafio_spring.desafio_spring.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductResponseDto> saveProducts(List<ProductRequestDto> productList);

    ProductResponseDto updateProduct(UUID id, ProductRequestDto productDto);

    List<ProductResponseDto> getAllProducts();

    List<ProductResponseDto> filterMultiples(String category, Boolean freeShipping, String prestige, Integer order);

    List<ProductResponseDto> getAllProductsByCategory(String category);

    List<Product> orderProducts(List<Product> productList, int order);
}
