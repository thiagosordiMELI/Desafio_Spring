package com.desafio_spring.desafio_spring.repository;

import com.desafio_spring.desafio_spring.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepo {
    private final String productsFile = "src/main/resources/products.json";

    public List<Product> getAllProducts() {
        ObjectMapper mapper = new ObjectMapper();
        List<Product> productsList = null;
        try {
            productsList = Arrays.asList
                    (mapper.readValue(new File(productsFile), Product[].class));
        } catch (Exception ex) {
            System.out.println("Não retorna produtos");
        }
        return productsList;
    }
}
