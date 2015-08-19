/*
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */

package com.market.dao;

import com.market.model.Product;
import java.util.List;

/**
 * ProductDAO Interface.
 *
 * @author Alex Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
public interface ProductDAO {

    /**
     * Get product by name.
     * @param name Name
     * @return Product
     */
    Product getProduct(String name);

    /**
     * Get all products.
     * @return Products
     */
    List<Product> getProducts();
}
