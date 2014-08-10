package com.market.service;

import com.market.dao.ProductDAO;
import com.market.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    ProductDAO productDAO;

    public Product getProduct(String name) {
        return productDAO.getProduct(name);
    }

    public List<Product> getProducts() {
        return productDAO.getProducts();
    }
}
