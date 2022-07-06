package com.desafio_spring.desafio_spring.repository;

import com.desafio_spring.desafio_spring.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private static final String dbFile = "src/main/resources/products.json";

    public List<Product> all() {
        try {
            var mapper = new ObjectMapper();
            return new ArrayList<>(List.of(mapper.readValue(new File(dbFile), Product[].class)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Product findById(long id) {
        var products = all();
        return products.stream().filter(p -> p.getProductId() == id).findFirst().orElse(null);
    }
}
