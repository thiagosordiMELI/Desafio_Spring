package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.CartDto;
import com.desafio_spring.desafio_spring.dto.PurchaseResponseDto;
import com.desafio_spring.desafio_spring.model.PurchaseProduct;

import java.util.List;

public interface PurchaseService {

    /**
     * Metódo do Service que cuida da lógica do controle de estoque, salvar a compra e por fim gerar um DTO de retorno.
     * @param products lista de objetos PurchaseProduct
     * @return O objeto PurchaseResponseDto que foi gerado, contendo todos os produtos em detalhes e o valor total da compra.
     */
    PurchaseResponseDto savePurchases(List<PurchaseProduct> products);

    /**
     * Metódo do Service que retorna valor total no carrinho
     * @return O objeto CartDto com o valor total.
     */
    CartDto getTotalInCart();
}
