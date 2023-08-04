package com.cg.service;

import com.cg.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ProductServiceImpl implements IProductService {

    static List<Product> products = new ArrayList<Product>();
    static Long productId = 1L;

    static {
        products.add(new Product(productId++, "Iphone 4", BigDecimal.valueOf(Long.parseLong("100")), "Chiếc", "Iphone"));
        products.add(new Product(productId++, "Iphone 5", BigDecimal.valueOf(Long.parseLong("150")), "Chiếc", "Iphone"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        for (Product item : products) {
            if (item.getId().equals(id)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    @Override
    public void add(Product product) {
        product.setId(productId++);
        products.add(product);
    }

    @Override
    public void update(Product product) {
        int index = -1;
        for (int i = 0; i < products.size(); i++ ) {
            if (Objects.equals(products.get(i).getId(), product.getId())) {
                index = i;
            }
        }

        if (index != -1) {
            products.set(index, product);
        }

    }
}
