package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.ProductRequestDto;
import com.desafio_spring.desafio_spring.dto.ProductDto;
import com.desafio_spring.desafio_spring.model.Product;

import java.util.List;
import java.util.UUID;

/**
 * Interface para a camada Service dos Produtos(Product).
 */
public interface ProductService {

    /**
     * Metódo do Service que cuida da lógica de salvar os produtos e gerar o DTO de saída.
     * @param productList lista de objetos ProductRequestDto
     * @return Lista de objetos ProductDto.
     */
    List<ProductDto> saveProducts(List<ProductRequestDto> productList);

    /**
     * Método do Service que cuida da lógica de editar as informações de um produto já existente.
     * @param id id do produto que será editado.
     * @param productDto DTO(Request) com as novas informações do produto.
     * @return productDto(Response) com as novas informações.
     */
    ProductDto updateProduct(UUID id, ProductRequestDto productDto);

    /**
     * Metódo do Service que cuida da lógica de pegar todos os produtos salvos.
     * @return Lista de objetos ProductDto.
     */
    List<ProductDto> getAllProducts();

    /**
     * Método do Service que cuida da lógica de pegar a lista de todos os produtos, ordenados conforme parâmetro recebido.
     * @param orderBy parâmetro que definirá a ordenação escolhida
     * @return Lista de ProductDto com a ordenação escolhida
     */
    List<ProductDto> getOrderedProducts(int orderBy);
}
