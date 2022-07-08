package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.ProductRequestDto;
import com.desafio_spring.desafio_spring.dto.ProductDto;
import com.desafio_spring.desafio_spring.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductDto> saveProducts(List<ProductRequestDto> productList);
    ProductDto updateProduct(UUID id, ProductRequestDto productDto);
    List<ProductDto> getAllProducts();

    List<ProductDto> filterMultiples(String category, Boolean freeShipping, String prestige, Integer order);
    List<ProductDto> getAllProductsByCategory(String category);
    List<Product> orderProducts(List<Product> productList, int order);
}
