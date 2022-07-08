package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.ProductResponseDto;
import com.desafio_spring.desafio_spring.dto.ProductRequestDto;
import com.desafio_spring.desafio_spring.exception.ParamInvalidException;
import com.desafio_spring.desafio_spring.model.Product;
import com.desafio_spring.desafio_spring.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
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
    public List<ProductResponseDto> saveProducts(List<ProductRequestDto> productList) {
        if (productList.size() == 0) {
            throw new ParamInvalidException("Lista não pode ser vazia.");
        }
        List<Product> newProducts = productList.stream()
                .map(Product::new)
                .collect(Collectors.toUnmodifiableList());
        List<Product> savedProducts = productRepo.saveProducts(newProducts);
        List<ProductResponseDto> productResponseDto = new ArrayList<>();
        savedProducts.forEach(product -> productResponseDto.add(new ProductResponseDto(product)));
        return productResponseDto;
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> productList = productRepo.getAllProducts();
        return productList.stream()
                .map(ProductResponseDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDto> filterMultiples(String category, Boolean freeShipping, String prestige, Integer order) {
        List<Product> products = productRepo.getAllProducts();
        if (category != null && !category.equals("")) {
            products = products.stream()
                    .filter(p -> p.getCategory().equals(category))
                    .collect(Collectors.toList());
        }
        if (prestige != null && !prestige.equals("")) {
            products = products.stream()
                    .filter(p -> p.getPrestige().equals(prestige))
                    .collect(Collectors.toList());
        }
        if (freeShipping != null) {
            products = products.stream()
                    .filter(p -> p.isFreeShipping() == freeShipping)
                    .collect(Collectors.toList());
        }
        if (order != null) {
            products = orderProducts(products, order);
        }
        return products.stream().map(ProductResponseDto::new).collect(Collectors.toList());
    }


    public List<ProductResponseDto> getAllProductsByCategory(String category) {
        List<Product> productsCategory = productRepo.getAllProductsByCategory(category);
        List<ProductResponseDto> lista = productsCategory.stream()
                .map(ProductResponseDto::new)
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

    public ProductResponseDto updateProduct(UUID id, ProductRequestDto productDto) {
        Product product = new Product(productDto);
        product.setProductId(id);
        return new ProductResponseDto(productRepo.updateProduct(product));
    }
}
