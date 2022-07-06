package com.desafio_spring.desafio_spring.repository;

import com.desafio_spring.desafio_spring.model.Product;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepo {
    private final String productsFile = "src/main/resources/products.json";
    public List<Product> saveProducts(List<Product> productList) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        List<Product> oldList;
        try {
            oldList = Arrays.asList(mapper.readValue(new File(productsFile), Product[].class));
            List<Product> newList = new ArrayList<>(oldList);
            productList.forEach(p -> newList.add(p));
            writer.writeValue(new File(productsFile), newList);
            return productList;
        } catch (Exception err) {
            System.out.println("Erro ao acessar o arquivo de produtos.");
        }
        return null; //TODO Substituir por exceção
    }

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
