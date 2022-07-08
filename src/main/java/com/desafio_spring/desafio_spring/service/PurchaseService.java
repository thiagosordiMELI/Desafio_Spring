package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.CartResponseDto;
import com.desafio_spring.desafio_spring.dto.PurchaseResponseDto;
import com.desafio_spring.desafio_spring.model.PurchaseProduct;

import java.util.List;

public interface PurchaseService {
    PurchaseResponseDto savePurchases(List<PurchaseProduct> products);
    CartResponseDto getTotalInCart();
}
