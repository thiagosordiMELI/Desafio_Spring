package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.ProductRequestDto;
import com.desafio_spring.desafio_spring.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> saveProducts(List<ProductRequestDto> productList);
    List<ProductDto> getAllProducts();
}
