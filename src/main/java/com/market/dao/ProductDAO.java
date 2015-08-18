/**
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

    public Product getProduct(String name);
    public List<Product> getProducts();
}
