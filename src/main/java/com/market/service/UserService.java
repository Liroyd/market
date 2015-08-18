/*
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */

package com.market.service;

import com.market.dao.UserDAO;
import com.market.model.Role;
import com.market.model.User;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User Service.
 *
 * @author Alex Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
@Service
public class UserService {
    /**
     * UserDAO.
     */
    @Autowired
    private UserDAO userDAO;

    /**
     * Get User.
     * @param name User name
     * @return User
     */
    public User getUser(String name) {
        return this.userDAO.getUser(name);
    }

    /**
     * Get Users.
     * @return List of users.
     */
    public List<User> getUsers() {
        return this.userDAO.getUsers();
    }

    /**
     * Create new user.
     * @param user User
     * @return User
     */
    public User createUser(User user) {
        return createUser(user.getName(), user.getPassword(), user.getRoles());
    }

    /**
     * Delete user.
     * @param name User name
     */
    public void deleteUser(String name) {
        this.userDAO.deleteUser(name);
    }

    /**
     * Create user.
     * @param name User name
     * @param password User password
     * @param roles User roles
     * @return User
     */
    public User createUser(String name, String password, Set<Role> roles) {
        return this.userDAO.createUser(name, password, roles);
    }

    /**
     * Is user exists?
     * @param name User name
     * @return Boolean
     */
    public boolean isUserExists(String name) {
        User user = getUser(name);
        return user != null;
    }

    /**
     * Has Role?
     * @param userName User name
     * @param role User role
     * @return Boolean
     */
    public boolean hasRole(String userName, String role) {
        return this.userDAO.hasRole(userName, role);
    }
}
