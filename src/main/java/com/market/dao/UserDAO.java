package com.market.dao;

import com.market.model.User;

public interface UserDAO {

    public User getUser(String login);
}
