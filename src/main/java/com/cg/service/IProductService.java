package com.cg.service;

import com.cg.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    void add(Product product);

    void update(Product product);
}
