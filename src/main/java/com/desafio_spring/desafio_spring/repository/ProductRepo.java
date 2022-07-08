package com.desafio_spring.desafio_spring.repository;

import com.desafio_spring.desafio_spring.exception.CustomException;
import com.desafio_spring.desafio_spring.model.Product;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Repository
public class ProductRepo {
    private final String productsFile = "src/main/resources/products.json";

    public List<Product> saveProducts(List<Product> newProducts) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        List<Product> oldList;
        try {
            oldList = Arrays.asList(mapper.readValue(new File(productsFile), Product[].class));
            List<Product> newList = new ArrayList<>(oldList);
            newProducts.forEach(p -> newList.add(p));
            writer.writeValue(new File(productsFile), newList);
            return newProducts;
        } catch (Exception err) {
            System.out.println("Erro ao acessar o arquivo de produtos.");
        }
        throw new RuntimeException("Erro ao salvar lista de produtos.");
    }

    public List<Product> getAllProducts() {
        ObjectMapper mapper = new ObjectMapper();
        List<Product> productsList = null;
        try {
            productsList = Arrays.asList
                    (mapper.readValue(new File(productsFile), Product[].class));
            // return productsList;
        } catch (CustomException | IOException ex) {
            throw new RuntimeException("Erro ao pegar lista de produtos.");
        }
        return productsList;
    }

    public Product findById(UUID id) {
        List<Product> products = getAllProducts();
        Product product = products.stream().filter(p -> p.getProductId().equals(id)).findFirst().orElse(null);
        if (product == null) {
            throw new CustomException("Não foi achado produto com id " + id);
        }
        return product;
    }


    public List<Product> getAllProductsByCategory(String category) {
        List<Product> productsList = getAllProducts();
        List<Product> productCategory = null;

        productCategory = productsList.stream()
                .filter(p -> p.getCategory().equals(category))
                .collect(Collectors.toList());

        return productCategory;
    }

    public Product updateProduct(Product product) {
        if (findById(product.getProductId()) != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                List<Product> products = Arrays.asList(mapper.readValue(new File(productsFile), Product[].class));
                products = products.stream().map(p -> {
                            if (p.getProductId().equals(product.getProductId()))
                                return product;
                            return p;
                        }
                ).collect(Collectors.toList());
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                mapper.writeValue(new File(productsFile), products);
                return product;
            } catch (Exception err) {
                System.out.println("Erro ao acessar o arquivo de produtos.");
            }
        }
        throw new RuntimeException("Erro ao atualizar produto.");
    }
}
