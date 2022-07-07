package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.CustomerDto;
import com.desafio_spring.desafio_spring.model.Customer;

import java.util.List;

public interface CustomerService {

    /**
     * Metódo do Service que cuida da lógica de pegar todos os clientes salvos.
     * @return Lista de objetos Customer.
     */
    List<Customer> getAllCustomers();

    /**
     * Metódo do Service que cuida da lógica de pegar todos os produtos salvos com filtro por Estado(state).
     * @param state Estado a ser filtrado na lista de clientes.
     * @return Lista de objetos Customer.
     */
    List<Customer> getAllCustomers(String state);

    /**
     * Metódo do Service que cuida da lógica de salvar um novo cliente (Customer).
     * @param customerDto objeto Customer a ser salvo.
     * @return objeto Customer que foi criado.
     */
    Customer saveCustomer(CustomerDto customerDto);
}
