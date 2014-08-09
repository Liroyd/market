package com.market.dao.impl;

import com.market.dao.UserDAO;
import com.market.model.Role;
import com.market.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Transactional(readOnly=true)
public class UserDAOImpl implements UserDAO{

    private SessionFactory sessionFactory;

    @Override
    public User getUser(String name) {
        Query query = openSession().createQuery("from User u where u.name = :name");
        query.setParameter("name", name);
        List userList = query.list();
        if (!userList.isEmpty())
            return (User) userList.get(0);
        else
            return null;
    }

    @Override
    public boolean hasRole(String name, String roleString) {
        if (StringUtils.isEmpty(roleString)) {
            return false;
        }
        User user = getUser(name);
        for (Role role : user.getRoles()) {
            if (roleString.equals(role.getName())) {
                return true;
            }
        }
        return false;
    }

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
