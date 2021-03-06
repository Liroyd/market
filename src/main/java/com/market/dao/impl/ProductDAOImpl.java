/*
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */

package com.market.dao.impl;

import com.market.dao.ProductDAO;
import com.market.model.Product;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * ProductDAO Implementation.
 *
 * @author Alex Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
@Repository
@Transactional(readOnly = true)
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Product getProduct(String name) {
        Query query = openSession().createQuery("from Product p where p.name = :name");
        query.setParameter("name", name);
        List productList = query.list();
        if (!productList.isEmpty()) {
            return (Product) productList.get(0);
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getProducts() {
        Query query = openSession().createQuery("from Product");
        return query.list();
    }

    /**
     * Get current session.
     * @return Session
     */
    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }
}
