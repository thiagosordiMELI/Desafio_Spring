package com.desafio_spring.desafio_spring.controller;

import com.desafio_spring.desafio_spring.dto.ProductDto;
import com.desafio_spring.desafio_spring.dto.ProductRequestDto;
import com.desafio_spring.desafio_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/api/v1")
/** Controller do Product.
 * @version 1.0
 * @since 1.0
 */
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/articles")
    /**
     * Metódo do Controller que retorna a lista de produtos salvos.
     * @return Uma lista de objetos ProductDto apenas com informações essenciais.
     */
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productsList =  service.getAllProducts();
        return ResponseEntity.ok(productsList);
    }

    @PostMapping("/insert-articles-request")
    /**
     * Metódo do Controller que recebe uma lista de produtos e envia ao service para salvá-los.
     * @param products lista de objetos ProductRequestDto
     * @return Uma lista de objetos ProductDto apenas com informações essenciais.
     */
    public ResponseEntity<List<ProductDto>> insertArticlesRequest(@RequestBody @Valid List<ProductRequestDto> products) {
        return ResponseEntity.ok(service.saveProducts(products));
    }

    /**
     * Metódo do Controller que retorna a lista de produtos ordenada.
     * @param order parâmetro que definirá a ordenação escolhida.
     * @return Uma lista de objetos ProductDto ordenados, com informações essenciais.
     */
    @GetMapping("/articles/")
    public ResponseEntity<List<ProductDto>> getAllOrdered(@RequestParam int order) {
        List<ProductDto> productsList = service.getOrderedProducts(order);
        return ResponseEntity.ok(productsList);
    }

    /**
     * Metódo do Controller que recebe um produto para ser atualizazado através de um método PUT.
     * @param id UUID do produto que será alterado.
     * @param productDto objeto ProductRequestDto com os novos dados do produto.
     * @return Um objeto ProductDto com as novas informações básicas do produto que foi atualizado.
     */
    @PutMapping("/update-article-request/{id}")
    public ResponseEntity<ProductDto> updateArticleRequest(@PathVariable UUID id, @RequestBody @Valid ProductRequestDto productDto) {
        return ResponseEntity.ok(service.updateProduct(id, productDto));
    }
}
