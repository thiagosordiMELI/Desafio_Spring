package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.model.Product;
import com.desafio_spring.desafio_spring.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> saveProducts(List<Product> productList);
    List<ProductDto> getAllProducts();
}
