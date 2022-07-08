package com.desafio_spring.desafio_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
/** DTO de requisição para inserir cliente
 * @version 1.0
 * @since 1.0
 */
public class CustomerDto {
    @NotBlank(message = "Campo nome não pode ser vazio")
    private String name;

    @NotBlank(message = "Campo e-mail não pode ser vazio")
    @Email(message = "Campo e-mail inválido")
    private String email;

    @NotBlank(message = "Campo cidade não pode ser vazio")
    private String city;

    @NotBlank(message = "Campo estado não pode ser vazio")
    private String state;
}
