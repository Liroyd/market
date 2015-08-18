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

    User getUser(String name);
    List<User> getUsers();
    User createUser(String name, String password, Set<Role> roles);
    void deleteUser(String name);
    boolean hasRole(String userName, String role);
}
