/*
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */

package com.market.dao;

import com.market.model.Role;
import com.market.model.User;
import java.util.List;
import java.util.Set;

/**
 * UserDAO Interface.
 *
 * @author Alex Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
public interface UserDAO {
    /**
     * Get user.
     * @param name Name
     * @return User
     */
    User getUser(String name);

    /**
     * Get all users.
     * @return List of users
     */
    List<User> getUsers();

    /**
     * Create user.
     * @param name Name
     * @param password Password
     * @param roles Roles
     * @return User
     */
    User createUser(String name, String password, Set<Role> roles);

    /**
     * Delete user.
     * @param name Name
     */
    void deleteUser(String name);

    /**
     * Has role?
     * @param name Name
     * @param role Role
     * @return  Boolean
     */
    boolean hasRole(String name, String role);
}
