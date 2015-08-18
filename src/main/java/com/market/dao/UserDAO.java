/**
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

    public User getUser(String name);
    public List<User> getUsers();
    public User createUser(String name, String password, Set<Role> roles);
    public void deleteUser(String name);
    public boolean hasRole(String userName, String role);
}
