package com.desafio_spring.desafio_spring.controller;

import com.desafio_spring.desafio_spring.dto.PurchaseProductRequestDto;
import com.desafio_spring.desafio_spring.dto.PurchaseResponseDto;
import com.desafio_spring.desafio_spring.model.PurchaseProduct;
import com.desafio_spring.desafio_spring.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/purchase-request")
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    /**
     * Metódo do Controller que recebe uma lista de produtos e envia ao service para criar a compra.
     * @param products lista de objetos PurchaseProductRequestDto
     * @return Um objeto PurchaseResponseDto contendo todas informações dos produtos na compra além do valor total.
     */
    @PostMapping
    public ResponseEntity<PurchaseResponseDto> createPurchase(@RequestBody PurchaseProduct[] products) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.savePurchases(List.of(products)));
    }
}
