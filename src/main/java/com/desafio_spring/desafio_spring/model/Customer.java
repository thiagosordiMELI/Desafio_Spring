package com.desafio_spring.desafio_spring.model;

import com.desafio_spring.desafio_spring.dto.CustomerRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
/** Representa um cliente
 * @version 1.0
 * @since 1.0
 */
public class Customer {
    private UUID id;
    private String name;
    private String email;
    private String city;
    private String state;

    public Customer(CustomerRequestDto dto) {
        setId(UUID.randomUUID());
        setName(dto.getName());
        setEmail(dto.getEmail());
        setCity(dto.getCity());
        setState(dto.getState());
    }
}
