package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.ProductResponseDto;
import com.desafio_spring.desafio_spring.dto.ProductRequestDto;
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
     * @return Lista de objetos ProductResponseDto.
     */
    List<ProductResponseDto> saveProducts(List<ProductRequestDto> productList);

    /**
     * Método do Service que cuida da lógica de editar as informações de um produto já existente.
     * @param id UUID do produto que será editado.
     * @param productDto objeto ProductRequestDto com as novas informações do produto.
     * @return Um objeto ProductResponseDto com as novas informações.
     */
    ProductResponseDto updateProduct(UUID id, ProductRequestDto productDto);

    /**
     * Metódo do Service que cuida da lógica de pegar todos os produtos salvos.
     * @return Lista de objetos ProductResponseDto.
     */
    List<ProductResponseDto> getAllProducts();

    /**
     * Método do Service que cuida da lógica de filtrar na lista de produtos conforme parâmetros recebidos.
     * @param category categoria do produto (opcional)
     * @param freeShipping flag de frete grátis (opcional)
     * @param prestige avaliacao em "*" do produto (opcional)
     * @param order opção de ordenação (opcional)
     * @return Lista de ProductResponseDto com filtragem e ordenação escolhida
     */
    List<ProductResponseDto> filterMultiples(String category, Boolean freeShipping, String prestige, Integer order);

    /**
     * Método do Service que cuida da lógica de filtrar na lista de produtos pela categoria.
     * @param category categoria do produto
     * @return Lista de ProductResponseDto filtrados pela categoria
     */
    List<ProductResponseDto> getAllProductsByCategory(String category);

    /**
     * Método do Service que cuida da lógica de ordenar lista de produtos conforme parâmetro recebido.
     * @param productList lista de produtos a serem ordenados
     * @param order parâmetro que definirá a ordenação escolhida
     * @return Lista de Product com a ordenação escolhida
     */
    List<Product> orderProducts(List<Product> productList, int order);
}
