/**
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */
package com.market.service;

import com.market.dao.RoleDAO;
import com.market.model.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Role Service.
 *
 * @author Alex Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
@Service
public class RoleService {
    /**
     * RoleDAO.
     */
    @Autowired
    RoleDAO roleDAO;

    /**
     * Get role.
     * @param name Role name
     * @return Role
     */
    public Role getRole(String name) {
        return this.roleDAO.getRole(name);
    }

    /**
     * Get Roles.
     * @return List of Roles
     */
    public List<Role> getRoles() {
        return this.roleDAO.getRoles();
    }
}
