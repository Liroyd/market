package com.market.dao;

import com.market.model.Role;

import java.util.List;

public interface RoleDAO {

    public Role getRole(String name);
    public List<Role> getRoles();
}
