package com.desafio_spring.desafio_spring.controller;

import com.desafio_spring.desafio_spring.DTO.ArticlesPurchaseRequestDto;
import com.desafio_spring.desafio_spring.DTO.TicketDto;
import com.desafio_spring.desafio_spring.service.PurchaseServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/purchase-request")
public class PurchaseController {

    private final PurchaseServiceInterface service;

    public PurchaseController(PurchaseServiceInterface service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TicketDto> createPurchase(@RequestBody ArticlesPurchaseRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request.articlesPurchaseRequest));
    }
}
