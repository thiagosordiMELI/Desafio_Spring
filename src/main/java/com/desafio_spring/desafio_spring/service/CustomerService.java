package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.CustomerRequestDto;
import com.desafio_spring.desafio_spring.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    List<Customer> getAllCustomers(String state);

    Customer saveCustomer(CustomerRequestDto customerRequestDto);
}
