package com.desafio_spring.desafio_spring.controller;

import com.desafio_spring.desafio_spring.dto.CartDto;
import com.desafio_spring.desafio_spring.dto.PurchaseResponseDto;
import com.desafio_spring.desafio_spring.model.PurchaseProduct;
import com.desafio_spring.desafio_spring.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/purchase-request")
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    @PostMapping
    public ResponseEntity<PurchaseResponseDto> createPurchase(@RequestBody PurchaseProduct[] products) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.savePurchases(List.of(products)));
    }

    @GetMapping("cart")
    public ResponseEntity<CartDto> getTotalInCart() {
        return ResponseEntity.ok(service.getTotalInCart());
    }
}
