package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.CartResponseDto;
import com.desafio_spring.desafio_spring.dto.PurchaseRequestDto;
import com.desafio_spring.desafio_spring.dto.PurchaseResponseDto;
import com.desafio_spring.desafio_spring.model.PurchaseProduct;

import java.util.List;
import java.util.UUID;

/**
 * Interface para a camada Service dos Carrinhos de Compra(Purchases).
 */
public interface PurchaseService {

    /**
     * Metódo do Service que cuida da lógica do controle de estoque, salvar a compra e por fim gerar um DTO de retorno.
     * @param purchase objeto PurchaseRequestDto
     * @return O objeto PurchaseResponseDto que foi gerado, contendo todos os produtos em detalhes, o cliente, e o valor total da compra.
     */
    PurchaseResponseDto savePurchases(PurchaseRequestDto purchase);

    /**
     * Metódo do Service que retorna valor total no carrinho de um cliente
     * @param customerId UUID do cliente
     * @return O objeto CartResponseDto com o valor total.
     */
    CartResponseDto getTotalInCart(UUID customerId);
}
