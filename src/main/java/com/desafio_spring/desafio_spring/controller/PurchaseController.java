package com.desafio_spring.desafio_spring.controller;

import com.desafio_spring.desafio_spring.dto.CartResponseDto;
import com.desafio_spring.desafio_spring.dto.PurchaseRequestDto;
import com.desafio_spring.desafio_spring.dto.PurchaseResponseDto;
import com.desafio_spring.desafio_spring.model.PurchaseProduct;
import com.desafio_spring.desafio_spring.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/** Controller do Purchase.
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("api/v1/purchase-request")
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    /**
     * Metódo do Controller que recebe uma lista de produtos de um cliente e envia ao service para criar a compra.
     * @param purchase objeto PurchaseRequestDto
     * @return Um objeto PurchaseResponseDto contendo todas informações dos produtos na compra além do valor total.
     */
    @PostMapping
    public ResponseEntity<PurchaseResponseDto> createPurchase(@RequestBody PurchaseRequestDto purchase) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.savePurchases(purchase));
    }

    /**
     * Metódo do Controller que retorna o valor total do carrinho de um cliente.
     * @param customerId UUID para resgatar carrinho de um cliente
     * @return Um objeto CartResponseDto contendo o valor total.
     */
    @GetMapping("cart/{customerId}")
    public ResponseEntity<CartResponseDto> getTotalInCart(@PathVariable UUID customerId) {
        return ResponseEntity.ok(service.getTotalInCart(customerId));
    }
}
