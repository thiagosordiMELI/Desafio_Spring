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

    public List<Purchase> getAllPurchases() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Purchase[] purchases = mapper.readValue(new File(dbPath), Purchase[].class);
            return new ArrayList<>(List.of(purchases));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao pegar lista de compras.");
        }
    }

    public Purchase savePurchase(Purchase purchase) {
        try {
            List<Purchase> allPurchases = getAllPurchases();
            allPurchases.add(purchase);

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(dbPath), allPurchases);

            return purchase;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar compra.");
        }
    }
}
