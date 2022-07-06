package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.DTO.PurchaseRequestDto;
import com.desafio_spring.desafio_spring.DTO.TicketDto;
import com.desafio_spring.desafio_spring.model.Purchase;
import com.desafio_spring.desafio_spring.repository.ProductRepository;
import com.desafio_spring.desafio_spring.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PurchaseService implements PurchaseServiceInterface {
    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;

    public PurchaseService(PurchaseRepository purchaseRepository, ProductRepository productRepository) {
        this.purchaseRepository = purchaseRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Purchase> all() {
        return null;
    }

    @Override
    public TicketDto save(List<PurchaseRequestDto> purchases) {
        var products = purchases.stream().map(x -> productRepository.findById(x.getProductId())).collect(Collectors.toList());
        var purchase = new Purchase();
        purchase.setId(1);
        purchase.setArticles(products);
        purchase.setTotal(products.stream().mapToDouble(p -> p.getPrice() * p.getQuantity()).sum());

        return new TicketDto(purchaseRepository.save(purchase));
    }
}
