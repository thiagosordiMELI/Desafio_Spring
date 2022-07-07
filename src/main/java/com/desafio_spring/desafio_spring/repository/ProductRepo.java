package com.desafio_spring.desafio_spring.repository;

import com.desafio_spring.desafio_spring.exception.ExceptionCustom;
import com.desafio_spring.desafio_spring.model.Product;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.*;
import java.io.IOException;
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
        throw new ExceptionCustom("Erro ao salvar lista de produtos.");
    }

    public List<Product> getAllProducts() {
        ObjectMapper mapper = new ObjectMapper();
        List<Product> productsList = null;
        try {
            productsList = Arrays.asList
                    (mapper.readValue(new File(productsFile), Product[].class));
            // return productsList;
        } catch (ExceptionCustom | IOException ex) {

        }
        if (productsList.size() == 0) throw new ExceptionCustom("Product not found");
        return productsList;
    }

    public Product findById(UUID id) {
        List<Product> products = getAllProducts();
        Product product = products.stream().filter(p -> p.getProductId().equals(id)).findFirst().orElse(null);
        if (product == null) {
            throw new ExceptionCustom("Não foi achado produto com id " + id);
        }
        return product;
    }


    public List<Product> getAllProductsByCategory(String category) {
        List<Product> productsList = getAllProducts();
        List<Product> productCategory = null;

        productCategory = ProductsList.stream()
                .filter(p -> p.getCategory().equals(category))
                .collect(Collectors.toList());

        if (productCategory.size() == 0) {
            throw new ExceptionCustom("A categoria não foi encontrada");
        }
        return productCategory;
    }

        public List<Product> getAllOrderByName () {
            return this.getAllProducts()
                    .stream()
                    .sorted(Comparator.comparing((Product::getName)))
                    .collect(Collectors.toList());
        }

        public List<Product> getAllOrderByPrice () {
            return this.getAllProducts()
                    .stream()
                    .sorted(Comparator.comparing((Product::getPrice)))
                    .collect(Collectors.toList());
        }

        public Product updateProduct (Product product){
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
            throw new ExceptionCustom("Erro ao atualizar produto.");
        }
    }
