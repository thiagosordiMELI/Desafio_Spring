package com.desafio_spring.desafio_spring.repository;

import com.desafio_spring.desafio_spring.model.Purchase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PurchaseRepo {
    private static final String dbPath = "src/main/resources/purchases.json";

    public List<Purchase> all() {
        try {
            var mapper = new ObjectMapper();
            var purchases = mapper.readValue(new File(dbPath), Purchase[].class);
            return new ArrayList<>(List.of(purchases));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Purchase save(Purchase purchase) {
        try {
            var all = all();
            all.add(purchase);

            var mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(dbPath), all);
            return purchase;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
