package com.desafio_spring.desafio_spring.repository;

import com.desafio_spring.desafio_spring.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepo {

    private static final String dbFile = "src/main/resources/customers.json";

    public List<Customer> getAllCustomers() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return new ArrayList<>(List.of(mapper.readValue(new File(dbFile), Customer[].class)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer saveCustomer(Customer customer) {
        try {
            List<Customer> customers = getAllCustomers();
            customers.add(customer);

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(dbFile), customers);

            return customer;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
