package com.desafio_spring.desafio_spring.controller;

import com.desafio_spring.desafio_spring.dto.ProductDto;
import com.desafio_spring.desafio_spring.dto.ProductRequestDto;
import com.desafio_spring.desafio_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/articles")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productsList =  service.getAllProducts();
        return ResponseEntity.ok(productsList);
    }

    @GetMapping("/teste")
    public ResponseEntity<List<ProductDto>> getAllProductsByCategory(@RequestParam String category) {
        List<ProductDto> productsList = service.getAllProductsByCategory(category);
        return ResponseEntity.ok(productsList);
    }

    @PostMapping("/insert-articles-request")
    public ResponseEntity<List<ProductDto>> insertArticlesRequest(@RequestBody @Valid List<ProductRequestDto> products) {
        return ResponseEntity.ok(service.saveProducts(products));
    }

    @GetMapping("/articles/")
    public ResponseEntity<List<ProductDto>> getAllOrdered(@RequestParam int order) {
        List<ProductDto> productsList = service.getOrderedProducts(order);
        return ResponseEntity.ok(productsList);
    }

    @PutMapping("/update-article-request/{id}")
    public ResponseEntity<ProductDto> updateArticleRequest(@PathVariable UUID id, @RequestBody @Valid ProductRequestDto productDto) {
        return ResponseEntity.ok(service.updateProduct(id, productDto));
    }
}
