package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.DTO.PurchaseRequestDto;
import com.desafio_spring.desafio_spring.DTO.TicketDto;
import com.desafio_spring.desafio_spring.model.Purchase;

import java.util.List;

public interface PurchaseServiceInterface {
    List<Purchase> all();
    TicketDto save(List<PurchaseRequestDto> purchase);
}
