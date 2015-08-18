/**
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */
package com.market.model;

import java.util.Set;
import javax.persistence.Id;

/**
 * User Model.
 *
 * @author Alex Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
public class User {

    @Id
    private String name;
    private String password;
    private Set<Role> roles;

    public User() {
    }

    public User(String name, String password, Set<Role> roles) {
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String login) {
        this.name = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return getName();
    }
}