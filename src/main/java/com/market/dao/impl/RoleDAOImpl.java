/*
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */

package com.market.dao.impl;

import com.market.dao.RoleDAO;
import com.market.model.Role;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *Role DAO Implementation.
 *
 * @author Alex Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
@Repository
@Transactional(readOnly = true)
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role getRole(String name) {
        Query query = openSession().createQuery("from Role r where r.name = :name");
        query.setParameter("name", name);
        List roleList = query.list();
        if (!roleList.isEmpty()) {
            return (Role) roleList.get(0);
        } else {
            return null;
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> getRoles() {
        Query query = openSession().createQuery("from Role");
        return query.list();
    }

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }
}
