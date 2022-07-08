package com.desafio_spring.desafio_spring.controller;

import com.desafio_spring.desafio_spring.dto.ProductResponseDto;
import com.desafio_spring.desafio_spring.dto.ProductRequestDto;
import com.desafio_spring.desafio_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<List<ProductResponseDto>> multipleFilters
            (@RequestParam(required = false) String category,
             @RequestParam(required = false) Boolean freeShipping,
             @RequestParam(required = false) String prestige,
             @RequestParam(required = false) Integer order) {
        List<ProductResponseDto> filteredResult;
        filteredResult = service.filterMultiples(category, freeShipping, prestige, order);
        return ResponseEntity.ok(filteredResult);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductResponseDto>> getAllProductsByCategory(@RequestParam String category) {
        List<ProductResponseDto> productsList = service.getAllProductsByCategory(category);
        return ResponseEntity.ok(productsList);
    }

    @PostMapping("/insert-articles-request")
    public ResponseEntity<List<ProductResponseDto>> insertArticlesRequest(
            @RequestBody @Valid List<ProductRequestDto> products) {
        return ResponseEntity.ok(service.saveProducts(products));
    }

    @PutMapping("/update-article-request/{id}")
    public ResponseEntity<ProductResponseDto> updateArticleRequest(@PathVariable UUID id, @RequestBody @Valid ProductRequestDto productDto) {
        return ResponseEntity.ok(service.updateProduct(id, productDto));
    }
}
