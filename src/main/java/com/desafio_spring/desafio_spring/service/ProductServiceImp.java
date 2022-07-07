package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.ProductDto;
import com.desafio_spring.desafio_spring.model.Product;
import com.desafio_spring.desafio_spring.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> productList = productRepo.getAllProducts();
        return productList.stream()
                .map(ProductDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getAllProductsByCategory(String category) {
        List<Product> ProductsList = productRepo.getAllProducts();
        List<ProductDto> lista = ProductsList.stream()
                .filter(p -> p.getCategory().equals(category))
                .map(ProductDto::new)
                .collect(Collectors.toList());
        System.out.println(lista);
        return lista;
    }
}
