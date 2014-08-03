package com.market.dao;

import com.market.model.User;

public interface UserDAO {

    public User getUser(String name);
    public boolean hasRole(String userName, String role);
}
