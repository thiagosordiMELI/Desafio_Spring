package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.ProductDto;
import com.desafio_spring.desafio_spring.dto.PurchaseProductResponseDto;
import com.desafio_spring.desafio_spring.dto.PurchaseResponseDto;
import com.desafio_spring.desafio_spring.dto.PurchaseProductRequestDto;
import com.desafio_spring.desafio_spring.exception.ExceptionCustom;
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
import java.util.stream.DoubleStream;

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
    public PurchaseResponseDto savePurchases(List<PurchaseProduct> products) {

        // Lógica para controle de estoque
        Map<UUID, Product> map =
                productRepository.getAllProducts().stream().collect(Collectors.toMap(Product::getProductId, item -> item));
        for(PurchaseProduct p : products){
            Product prod =  map.get(p.getProductId());
            if(prod.getQuantity() >= p.getQuantity()){
                prod.setQuantity(prod.getQuantity() - p.getQuantity());
            }else{
                throw new ExceptionCustom("Sem estoque");
            }
        }

        // Atualiza o registro de Produto no arquivo
        products.stream().forEach(p -> productRepository.updateProduct(map.get(p.getProductId())));

        Purchase purchase = new Purchase(UUID.randomUUID(), products);

        purchaseRepo.savePurchase(purchase);

        // Soma o total da compra
        DoubleStream productsTotalPrice = products
                .stream()
                .mapToDouble(p -> productRepository.findById(p.getProductId()).getPrice() * p.getQuantity());

        return new PurchaseResponseDto(purchase.getId(),
                products
                        .stream()
                        .map(x -> new PurchaseProductResponseDto(map.get(x.getProductId()), x.getQuantity()))
                        .collect(Collectors.toList()),
                productsTotalPrice.sum());
    }
}
