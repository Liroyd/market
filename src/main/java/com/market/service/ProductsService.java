/**
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */
package com.market.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.market.dao.ProductDAO;
import com.market.model.Product;

/**
 * Products Service.
 *
 * @author Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
@Service
public class ProductsService {

    /**
     * ProductDAO.
     */
    @Autowired
    ProductDAO productDAO;

    /**
     * Get Product.
     * @param name Name of Product
     * @return Product
     */
    public Product getProduct(final String name) {
        return productDAO.getProduct(name);
    }

    /**
     * Get Products.
     * @return Products
     */
    public List<Product> getProducts() {
        return productDAO.getProducts();
    }
}
