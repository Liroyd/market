/*
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */

package com.market.model;

import javax.persistence.Id;

/**
 * Role Model.
 *
 * @author Alex Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
public class Role {

    @Id
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String role) {
        this.name = role;
    }

    @Override
    public String toString() {
        return getName();
    }
}
