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
     * Metódo do Controller que retorna a lista de produtos salvos com combinação de filtros e ordenação opcionais.
     * @param category categoria do produto (opcional)
     * @param freeShipping flag de frete grátis (opcional)
     * @param prestige avaliacao em "*" do produto (opcional)
     * @param order opção de ordenação (opcional)
     * @return Uma lista de objetos ProductDto filtrada e ordenada apenas com informações essenciais.
     */
    public ResponseEntity<List<ProductDto>> multipleFilters
            (@RequestParam(required = false) String category,
             @RequestParam(required = false) Boolean freeShipping,
             @RequestParam(required = false) String prestige,
             @RequestParam(required = false) Integer order) {
        List<ProductDto> filteredResult;
        filteredResult = service.filterMultiples(category, freeShipping, prestige, order);
        return ResponseEntity.ok(filteredResult);
    }

    @GetMapping("/")
    /**
     * Metódo do Controller que retorna a lista de produtos filtrados por categoria.
     * @param category categoria de produto para filtro
     * @return Uma lista de objetos ProductDto filtrada por categoria e apenas com informações essenciais.
     */
    public ResponseEntity<List<ProductDto>> getAllProductsByCategory(@RequestParam String category) {
        List<ProductDto> productsList = service.getAllProductsByCategory(category);
        return ResponseEntity.ok(productsList);
    }

    @PostMapping("/insert-articles-request")
    /**
     * Metódo do Controller que recebe uma lista de produtos e envia ao service para salvá-los.
     * @param products lista de objetos ProductRequestDto
     * @return Uma lista de objetos ProductDto apenas com informações essenciais.
     */
    public ResponseEntity<List<ProductDto>> insertArticlesRequest(
            @RequestBody @Valid List<ProductRequestDto> products) {
        return ResponseEntity.ok(service.saveProducts(products));
    }

    @PutMapping("/update-article-request/{id}")
    /**
     * Metódo do Controller que recebe um produto para ser atualizazado através de um método PUT.
     * @param id UUID do produto que será alterado.
     * @param productDto objeto ProductRequestDto com os novos dados do produto.
     * @return Um objeto ProductDto com as novas informações básicas do produto que foi atualizado.
     */
    public ResponseEntity<ProductDto> updateArticleRequest(@PathVariable UUID id, @RequestBody @Valid ProductRequestDto productDto) {
        return ResponseEntity.ok(service.updateProduct(id, productDto));
    }
}
