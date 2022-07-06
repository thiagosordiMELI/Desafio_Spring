package com.desafio_spring.desafio_spring.controler;

import com.desafio_spring.desafio_spring.dto.ProductDto;
import com.desafio_spring.desafio_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
