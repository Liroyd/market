/*
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */

package com.market.service;

import com.market.dao.ProductDAO;
import com.market.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Product Service.
 *
 * @author Alex Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
@Service
public class ProductService {

    /**
     * ProductDAO.
     */
    @Autowired
    private ProductDAO productDAO;

    /**
     * Get Product.
     * @param name Name of Product
     * @return Product
     */
    public Product getProduct(final String name) {
        return this.productDAO.getProduct(name);
    }

    /**
     * Get Products.
     * @return Products
     */
    public List<Product> getProducts() {
        return this.productDAO.getProducts();
    }
}
