package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.ProductRequestDto;
import com.desafio_spring.desafio_spring.dto.ProductDto;
import com.desafio_spring.desafio_spring.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> saveProducts(List<ProductRequestDto> productList);
    ProductDto updateProduct(Product product);
    List<ProductDto> getAllProducts();
}
