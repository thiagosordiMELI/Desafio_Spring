package com.desafio_spring.desafio_spring.controller;

import com.desafio_spring.desafio_spring.dto.CustomerRequestDto;
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
/** Controller do Customer.
 * @version 1.0
 * @since 1.0
 */
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    /**
     * Metódo do Controller que retorna a lista de clientes salvos, podendo ou não filtrar pelo estado.
     * @return Uma lista de objetos Customer.
     */
    public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(required = false) String state) {
        return state != null
                ? ResponseEntity.ok(service.getAllCustomers(state))
                : ResponseEntity.ok(service.getAllCustomers());
    }

    @PostMapping
    /**
     * Metódo do Controller que recebe um cliente e envia ao service para salvá-lo.
     * @param customerDto objeto CustomerRequestDto
     * @return O objeto Customer que foi salvo.
     */
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid CustomerRequestDto customerRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveCustomer(customerRequestDto));
    }
}
