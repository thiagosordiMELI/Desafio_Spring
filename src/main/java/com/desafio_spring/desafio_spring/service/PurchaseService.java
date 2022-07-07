package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.PurchaseProductRequestDto;
import com.desafio_spring.desafio_spring.dto.PurchaseResponseDto;
import com.desafio_spring.desafio_spring.model.Purchase;
import com.desafio_spring.desafio_spring.model.PurchaseProduct;

import java.util.List;

public interface PurchaseService {
    List<Purchase> getAllPurchases();
    PurchaseResponseDto savePurchases(List<PurchaseProduct> products);
}
