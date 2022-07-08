package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.CartDto;
import com.desafio_spring.desafio_spring.dto.PurchaseProductResponseDto;
import com.desafio_spring.desafio_spring.dto.PurchaseResponseDto;
import com.desafio_spring.desafio_spring.exception.CustomException;
import com.desafio_spring.desafio_spring.exception.ParamInvalidException;
import com.desafio_spring.desafio_spring.model.Product;
import com.desafio_spring.desafio_spring.model.Purchase;
import com.desafio_spring.desafio_spring.model.PurchaseProduct;
import com.desafio_spring.desafio_spring.repository.ProductRepo;
import com.desafio_spring.desafio_spring.repository.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImp implements PurchaseService {
    @Autowired
    private PurchaseRepo purchaseRepo;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public PurchaseResponseDto savePurchases(List<PurchaseProduct> purchaseProducts) {
        // Lógica para controle de estoque
        Map<UUID, Product> productMap = getProductMap();

        for (PurchaseProduct pp : purchaseProducts) {
            Product product = productMap.get(pp.getProductId());
            if (product == null) {
                throw new CustomException("Produto(s) inexistente(s)");
            }
            if (product.getQuantity() >= pp.getQuantity()) {
                product.setQuantity(product.getQuantity() - pp.getQuantity());
            } else {
                throw new ParamInvalidException("Sem estoque para o produto: " + product.getName() + " id: " + product.getProductId());
            }
        }

        // Atualiza o registro de Produto no arquivo
        purchaseProducts.forEach(p -> productRepo.updateProduct(productMap.get(p.getProductId())));
        Purchase purchase = new Purchase(UUID.randomUUID(), purchaseProducts);
        purchaseRepo.savePurchase(purchase);

        // Soma o total da compra
        double total = purchaseProducts
                .stream()
                .mapToDouble(p -> productMap.get(p.getProductId()).getPrice() * p.getQuantity())
                .sum();

        return new PurchaseResponseDto(
                purchase.getId(),
                purchaseProducts
                        .stream()
                        .map(x -> new PurchaseProductResponseDto(productMap.get(x.getProductId()), x.getQuantity()))
                        .collect(Collectors.toList()),
                total);
    }

    @Override
    public CartDto getTotalInCart() {
        Map<UUID, Product> map = getProductMap();

        double total = purchaseRepo
                .getAllPurchases()
                .stream()
                .flatMap(x -> x.getProducts().stream())
                .mapToDouble(x -> x.getQuantity() * map.get(x.getProductId()).getPrice())
                .sum();

        return new CartDto(total);
    }

    private Map<UUID, Product> getProductMap() {
        return productRepo.getAllProducts()
                .stream()
                .collect(Collectors.toMap(Product::getProductId, item -> item));
    }
}
