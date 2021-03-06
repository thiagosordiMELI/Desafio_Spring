package com.desafio_spring.desafio_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/** DTO de requisição para inserir cliente
 * @version 1.0
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {
    @NotBlank(message = "Campo 'name' não pode ser vazio")
    private String name;

    @NotBlank(message = "Campo 'email' não pode ser vazio")
    @Email(message = "Campo 'email' inválido")
    private String email;

    @NotBlank(message = "Campo 'city' não pode ser vazio")
    private String city;

    @NotBlank(message = "Campo 'state' não pode ser vazio")
    private String state;
}
