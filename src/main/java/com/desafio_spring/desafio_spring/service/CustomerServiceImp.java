package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.dto.CustomerDto;
import com.desafio_spring.desafio_spring.exception.CustomerAlreadyExistsException;
import com.desafio_spring.desafio_spring.model.Customer;
import com.desafio_spring.desafio_spring.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepo repo;

    @Override
    public List<Customer> getAllCustomers() {
        return repo.getAllCustomers();
    }

    @Override
    public List<Customer> getAllCustomers(String state) {
        return getAllCustomers()
                .stream()
                .filter(x -> statesAreEqual(x.getState(), state))
                .collect(Collectors.toList());
    }

    @Override
    public Customer saveCustomer(CustomerDto customerDto) {
        Optional<Customer> foundCustomer = getAllCustomers()
                .stream()
                .filter(x -> x.getEmail().equalsIgnoreCase(customerDto.getEmail()))
                .findFirst();

        if (foundCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException();
        }

        return repo.saveCustomer(new Customer(customerDto));
    }

    private static boolean statesAreEqual(String state1, String state2) {
        return state1.trim().equalsIgnoreCase(state2.trim());
    }
}
