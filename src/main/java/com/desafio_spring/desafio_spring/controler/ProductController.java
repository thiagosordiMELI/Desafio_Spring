package com.desafio_spring.desafio_spring.controler;

import com.desafio_spring.desafio_spring.DTO.ProdutoDTO;
import com.desafio_spring.desafio_spring.model.Product;
import com.desafio_spring.desafio_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    ProductService service;

    @PostMapping("/insert-articles-request")
    public ResponseEntity<List<ProdutoDTO>> insertArticlesRequest(@RequestBody List<Product> products) {
        return ResponseEntity.ok(service.saveList(products));
    }
}
