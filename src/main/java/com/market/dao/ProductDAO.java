package com.market.dao;

import com.market.model.Product;

import java.util.List;

public interface ProductDAO {

    public Product getProduct(String name);
    public List<Product> getProducts();
}
