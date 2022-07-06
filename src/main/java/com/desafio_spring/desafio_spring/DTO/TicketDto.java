package com.desafio_spring.desafio_spring.DTO;

import com.desafio_spring.desafio_spring.model.Purchase;

public class TicketDto {
    public Purchase ticket;

    public TicketDto(Purchase ticket) {
        this.ticket = ticket;
    }
}
