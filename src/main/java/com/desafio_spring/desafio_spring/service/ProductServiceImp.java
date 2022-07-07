package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.ProductDto;
import com.desafio_spring.desafio_spring.dto.ProductRequestDto;
import com.desafio_spring.desafio_spring.model.Product;
import com.desafio_spring.desafio_spring.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<ProductDto> saveProducts(List<ProductRequestDto> productList) {
        List<Product> newProducts = productList.stream()
                .map(product -> new Product(product))
                .collect(Collectors.toUnmodifiableList());
        List<Product> savedProducts = productRepo.saveProducts(newProducts);
        List<ProductDto> productDto = new ArrayList<>();
        savedProducts.forEach(product -> productDto.add(new ProductDto(product)));
        return productDto;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> productList = productRepo.getAllProducts();
        return productList.stream()
                .map(ProductDto::new).collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Product product) {
        return new ProductDto(productRepo.updateProduct(product));
    }
}
