package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.PurchaseProductRequestDto;
import com.desafio_spring.desafio_spring.dto.PurchaseResponseDto;
import com.desafio_spring.desafio_spring.model.Purchase;

import java.util.List;

public interface PurchaseService {
    List<Purchase> getAllPurchases();
    /**
     * Metódo do Service que cuida da lógica de colocar os produtos dentro da compra, salvar a compra e por fim gerar um DTO de retorno.
     * @param purchases lista de objetos PurchaseProductRequestDto
     * @return O objeto PurchaseResponseDto que foi gerado, contendo todos os produtos em detalhes e o valor total da compra.
     */
    PurchaseResponseDto savePurchases(List<PurchaseProductRequestDto> purchases);
}
