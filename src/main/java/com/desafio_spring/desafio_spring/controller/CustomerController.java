package com.desafio_spring.desafio_spring.controller;

import com.desafio_spring.desafio_spring.dto.CustomerDto;
import com.desafio_spring.desafio_spring.model.Customer;
import com.desafio_spring.desafio_spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(required = false) String state) {
        return state != null
                ? ResponseEntity.ok(service.getAllCustomers(state))
                : ResponseEntity.ok(service.getAllCustomers());
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid CustomerDto customerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveCustomer(customerDto));
    }
}
