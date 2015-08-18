/*
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */

package com.market.model;

import javax.persistence.Id;

/**
 * Product Model.
 *
 * @author Alex Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
public class Product {

    @Id
    private String name;
    private float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getName();
    }
}
