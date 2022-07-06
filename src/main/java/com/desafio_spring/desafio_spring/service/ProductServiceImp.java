package com.desafio_spring.desafio_spring.service;

import com.desafio_spring.desafio_spring.DTO.ProdutoDTO;
import com.desafio_spring.desafio_spring.model.Product;
import com.desafio_spring.desafio_spring.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepo repo;

    @Override
    public List<ProdutoDTO> saveList(List<Product> productList) {
        repo.saveList(productList);
        List<ProdutoDTO> productDto = new ArrayList<>();
        productList.forEach(p -> productDto.add(new ProdutoDTO(p)));
        return productDto;
    }
}
