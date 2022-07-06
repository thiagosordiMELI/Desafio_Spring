package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.PurchaseResponseDto;
import com.desafio_spring.desafio_spring.dto.PurchaseProductRequestDto;
import com.desafio_spring.desafio_spring.model.Purchase;
import com.desafio_spring.desafio_spring.repository.ProductRepo;
import com.desafio_spring.desafio_spring.repository.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImp implements PurchaseService {
    @Autowired
    private PurchaseRepo purchaseRepo;

    @Autowired
    private ProductRepo productRepository;

    @Override
    public List<Purchase> getAllPurchases() {
        return null;
    }

    @Override
    public PurchaseResponseDto savePurchases(List<PurchaseProductRequestDto> purchases) {
        var products = purchases.stream()
                .map(x -> {
                    var product = productRepository.findById(x.getId());
                    product.setQuantity(x.getQuantity());
                    return product;
                })
                .collect(Collectors.toList());

        var purchase = new Purchase(UUID.randomUUID(), products);

        purchaseRepo.savePurschase(purchase);

        return new PurchaseResponseDto(
                purchase.getId(),
                products,
                products.stream().mapToDouble(x -> x.getPrice() * x.getQuantity()).sum());
    }
}
