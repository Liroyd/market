/**
 * Copyright (c) 2015. Liroyd. All rights reserved.
 */

package com.market.service;

import com.market.dao.RoleDAO;
import com.market.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleDAO roleDAO;

    public Role getRole(String name) {
        return roleDAO.getRole(name);
    }

    public List<Role> getRoles() {
        return roleDAO.getRoles();
    }
}
