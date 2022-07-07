package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.ProductDto;
import com.desafio_spring.desafio_spring.dto.ProductRequestDto;
import com.desafio_spring.desafio_spring.model.Product;
import com.desafio_spring.desafio_spring.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<ProductDto> saveProducts(List<ProductRequestDto> productList) {
        List<Product> newProducts = productList.stream()
                .map(product -> new Product(product))
                .collect(Collectors.toUnmodifiableList());
        List<Product> savedProducts = productRepo.saveProducts(newProducts);
        List<ProductDto> productDto = new ArrayList<>();
        savedProducts.forEach(product -> productDto.add(new ProductDto(product)));
        return productDto;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> productList = productRepo.getAllProducts();
        return productList.stream()
                .map(ProductDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getAllProductsByCategory(String category) {
        List<Product> productsCategory = productRepo.getAllProductsByCategory(category);
        List<ProductDto> lista = productsCategory.stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
        return lista;
    }

        public List<ProductDto> getOrderedProducts(int order) {
            List<Product> productList;
            List<ProductDto> productDtoList = new ArrayList<>();
            switch (order) {
                case 0: {
                    productList = productRepo.getAllOrderByName();
                    productList.forEach(product -> productDtoList.add(new ProductDto(product)));
                    return productDtoList;
                }
                case 1: {
                    productList = productRepo.getAllOrderByName();
                    productList.forEach(product -> productDtoList.add(new ProductDto(product)));
                    Collections.reverse(productDtoList);
                    return productDtoList;
                }
                case 2: {
                    productList = productRepo.getAllOrderByPrice();
                    productList.forEach(product -> productDtoList.add(new ProductDto(product)));
                    Collections.reverse(productDtoList);
                    return productDtoList;
                }
                case 3: {
                    productList = productRepo.getAllOrderByPrice();
                    productList.forEach(product -> productDtoList.add(new ProductDto(product)));
                    return productDtoList;
                }
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public ProductDto updateProduct (UUID id, ProductRequestDto productDto){
            Product product = new Product(productDto);
            product.setProductId(id);
            return new ProductDto(productRepo.updateProduct(product));
        }
    }
