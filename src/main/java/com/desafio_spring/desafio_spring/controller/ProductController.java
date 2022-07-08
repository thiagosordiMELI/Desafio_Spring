package com.desafio_spring.desafio_spring.controller;

import com.desafio_spring.desafio_spring.dto.ProductDto;
import com.desafio_spring.desafio_spring.dto.ProductRequestDto;
import com.desafio_spring.desafio_spring.model.Product;
import com.desafio_spring.desafio_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService service;

//    @GetMapping("/articles")
//    public ResponseEntity<List<ProductDto>> getAllProducts() {
//        List<ProductDto> productsList =  service.getAllProducts();
//        return ResponseEntity.ok(productsList);
//    }

    @GetMapping("/articles")
    public ResponseEntity<List<ProductDto>> multipleFilters
            (@RequestParam(required = false) String category,
             @RequestParam(required = false) Boolean freeShipping,
             @RequestParam(required = false) String prestige) {
        List<ProductDto> filteredResult;
        filteredResult = service.filterMultiples(category, freeShipping, prestige);
        return ResponseEntity.ok(filteredResult);
    }

    @PostMapping("/insert-articles-request")
    public ResponseEntity<List<ProductDto>> insertArticlesRequest(
            @RequestBody @Valid List<ProductRequestDto> products) {
        return ResponseEntity.ok(service.saveProducts(products));
    }
}
