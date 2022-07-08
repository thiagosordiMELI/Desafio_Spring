package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.*;
import com.desafio_spring.desafio_spring.exception.CustomException;
import com.desafio_spring.desafio_spring.exception.ParamInvalidException;
import com.desafio_spring.desafio_spring.model.Product;
import com.desafio_spring.desafio_spring.model.Purchase;
import com.desafio_spring.desafio_spring.model.PurchaseProduct;
import com.desafio_spring.desafio_spring.repository.CustomerRepo;
import com.desafio_spring.desafio_spring.repository.ProductRepo;
import com.desafio_spring.desafio_spring.repository.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service do Purchase, implementa Interface PurchaseService.
 *
 * @version 1.0
 * @since 1.0
 */
@Service
public class PurchaseServiceImp implements PurchaseService {
    @Autowired
    private PurchaseRepo purchaseRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public PurchaseResponseDto savePurchases(PurchaseRequestDto purchaseRequest) {
        Map<UUID, Product> productsAfterSale = preBookProducts(purchaseRequest);

        // Atualiza o registro de Produto no arquivo
        purchaseRequest.getProducts().forEach(p -> productRepo.updateProduct(productsAfterSale.get(p.getProductId())));
        Purchase purchase = new Purchase(UUID.randomUUID(), purchaseRequest.getCustomerId(), purchaseRequest.getProducts());
        purchaseRepo.savePurchase(purchase);

        double total = purchaseRequest.getProducts()
                .stream()
                .mapToDouble(p -> productsAfterSale.get(p.getProductId()).getPrice() * p.getQuantity())
                .sum();

        return new PurchaseResponseDto(
                purchase.getId(),
                customerRepo.findById(purchaseRequest.getCustomerId()),
                purchaseRequest.getProducts().stream()
                        .map(x -> new PurchaseProductResponseDto(productsAfterSale.get(x.getProductId()), x.getQuantity()))
                        .collect(Collectors.toList()),
                total);
    }

    @Override
    public CartResponseDto getTotalInCart(UUID customerId) {
        customerRepo.findById(customerId);

        Map<UUID, Product> map = getProductMap();

        double total = purchaseRepo
                .getAllPurchases()
                .stream()
                .filter(p -> p.getClientId().equals(customerId))
                .flatMap(x -> x.getProducts().stream())
                .mapToDouble(x -> x.getQuantity() * map.get(x.getProductId()).getPrice())
                .sum();

        return new CartResponseDto(total);
    }

    private Map<UUID, Product> getProductMap() {
        return productRepo.getAllProducts()
                .stream()
                .collect(Collectors.toMap(Product::getProductId, item -> item));
    }

    private Map<UUID, Product> preBookProducts(PurchaseRequestDto purchaseRequest) {
        Map<UUID, Product> productMap = getProductMap();
        for (PurchaseProduct pp : purchaseRequest.getProducts()) {
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
        return productMap;
    }
}
