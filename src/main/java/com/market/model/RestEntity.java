/**
 * Copyright (c) 2015. Liroyd. All rights reserved.
 */

package com.market.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "restEntity")
public class RestEntity {

    String name;
    int quantity;

    public RestEntity(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public RestEntity() {
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    @XmlElement
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}