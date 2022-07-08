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
/** Repository do Purchase.
 * @version 1.0
 * @since 1.0
 */
public class PurchaseRepo {
    private static final String dbPath = "src/main/resources/purchases.json";

    /**
     * Metódo do Repository que retorna todas compras salvas em um arquivo JSON.
     * @return Uma lista de objetos Purchase.
     */
    public List<Purchase> getAllPurchases() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Purchase[] purchases = mapper.readValue(new File(dbPath), Purchase[].class);
            return new ArrayList<>(List.of(purchases));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metódo do Repository que salva uma compra em um arquivo JSON.
     * @param purchase objeto Purchase
     * @return O objeto Purchase que foi salvo no arquivo JSON.
     */
    public Purchase savePurchase(Purchase purchase) {
        try {
            List<Purchase> allPurchases = getAllPurchases();
            allPurchases.add(purchase);

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(dbPath), allPurchases);

            return purchase;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
