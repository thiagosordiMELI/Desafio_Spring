package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.ProductDto;
import com.desafio_spring.desafio_spring.exception.ExceptionCustom;
import com.desafio_spring.desafio_spring.model.Product;
import com.desafio_spring.desafio_spring.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<ProductDto> saveProducts(List<Product> productList) {
        productRepo.saveProducts(productList);
        List<ProductDto> productDto = new ArrayList<>();
        productList.forEach(product -> productDto.add(new ProductDto(product)));
        return productDto;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> productList = productRepo.getAllProducts();
        return productList.stream()
                .map(ProductDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getOrderedProducts(int orderBy) {
        List<Product> productList;
        List<ProductDto> productDtoList = new ArrayList<>();
        switch (orderBy) {
            case 0: {
                productList = productRepo.getAllOrderByName();
                productList.forEach(product -> productDtoList.add(new ProductDto(product)));
                return productDtoList;
            }
            case 1: {
                productList = productRepo.getAllOrderByName();
                productList.forEach(product -> productDtoList.add(new ProductDto(product)));
                return productDtoList.stream()
                        .sorted(Comparator.comparing(ProductDto::getName)
                                .reversed())
                        .collect(Collectors.toList());
            }
            default: throw new ExceptionCustom("Ordem não permitida.");
        }
    }

}
