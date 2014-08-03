package com.market.dao.impl;

import com.market.dao.UserDAO;
import com.market.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDAOImpl implements UserDAO{

    private SessionFactory sessionFactory;

    public User getUser(String name) {
        Query query = openSession().createQuery("from User u where u.name = :name");
        query.setParameter("name", name);
        List userList = query.list();
        if (!userList.isEmpty())
            return (User) userList.get(0);
        else
            return null;
    }

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
