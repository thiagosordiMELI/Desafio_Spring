package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.ProductDto;
import com.desafio_spring.desafio_spring.dto.ProductRequestDto;
import com.desafio_spring.desafio_spring.model.Product;
import com.desafio_spring.desafio_spring.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
/** Service do Product, implementa Interface ProductService.
 * @version 1.0
 * @since 1.0
 */
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<ProductDto> saveProducts(List<ProductRequestDto> productList) {
        List<Product> newProducts = productList.stream()
                .map(Product::new)
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
    public List<ProductDto> filterMultiples(String category, Boolean freeShipping, String prestige, Integer order) {
        List<Product> products = productRepo.getAllProducts();
        if (category != null) {
            products = products.stream()
                    .filter(p -> p.getCategory().equals(category))
                    .collect(Collectors.toList());
        }
        if (prestige != null) {
            products = products.stream()
                    .filter(p -> p.getPrestige().equals(prestige))
                    .collect(Collectors.toList());
        }
        if (freeShipping != null) {
            products = products.stream()
                    .filter(p -> p.isFreeShipping() == freeShipping)
                    .collect(Collectors.toList());
        }
        if(order != null) {
            products = orderProducts(products, order);
        }
        return products.stream().map(ProductDto::new).collect(Collectors.toList());
    }


    public List<ProductDto> getAllProductsByCategory(String category) {
        List<Product> productsCategory = productRepo.getAllProductsByCategory(category);
        List<ProductDto> lista = productsCategory.stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
        return lista;
    }

    public List<Product> orderProducts(List<Product> productList, int order) {
        switch (order) {
            case 0: {
                return productList.stream()
                        .sorted(Comparator.comparing((Product::getName)))
                        .collect(Collectors.toList());
            }
            case 1: {
                return productList.stream()
                        .sorted(Comparator.comparing((Product::getName))
                                .reversed())
                        .collect(Collectors.toList());
            }
            case 2: {
                return productList.stream()
                        .sorted(Comparator.comparing((Product::getPrice))
                                .reversed())
                        .collect(Collectors.toList());
            }
            case 3: {
                return productList.stream()
                        .sorted(Comparator.comparing((Product::getPrice)))
                        .collect(Collectors.toList());
            }
            default:
                throw new UnsupportedOperationException();
        }
    }

    public ProductDto updateProduct(UUID id, ProductRequestDto productDto) {
        Product product = new Product(productDto);
        product.setProductId(id);
        return new ProductDto(productRepo.updateProduct(product));
    }
}
