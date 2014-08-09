package com.market.model;

public class Role {

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
