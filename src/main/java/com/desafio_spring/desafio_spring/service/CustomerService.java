package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.CustomerDto;
import com.desafio_spring.desafio_spring.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    List<Customer> getAllCustomers(String state);
    Customer saveCustomer(CustomerDto customerDto);
}
