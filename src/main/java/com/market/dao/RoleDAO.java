/*
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */

package com.market.dao;

import com.market.model.Role;
import java.util.List;

/**
 * RoleDAO Interface.
 *
 * @author Alex Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
public interface RoleDAO {
    /**
     * Get all roles of user.
     * @param name User name
     * @return Roles
     */
    Role getRole(String name);

    /**
     * Get all Roles.
     * @return Roles
     */
    List<Role> getRoles();
}
