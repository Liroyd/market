/**
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

    public Role getRole(String name);
    public List<Role> getRoles();
}
