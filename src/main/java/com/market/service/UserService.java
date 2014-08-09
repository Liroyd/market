package com.market.service;

import com.market.dao.UserDAO;
import com.market.model.Role;
import com.market.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public User getUser(String name) {
        return userDAO.getUser(name);
    }

    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    public User createUser(User user) {
        return createUser(user.getName(), user.getPassword(), user.getRoles());
    }

    public void deleteUser(String name) {
        userDAO.deleteUser(name);
    }

    public User createUser(String name, String password, Set<Role> roles) {
        return userDAO.createUser(name, password, roles);
    }

    public boolean isUserExists(String name) {
        User user = getUser(name);
        return user != null;
    }

    public boolean hasRole(String userName, String role) {
        return userDAO.hasRole(userName, role);
    }
}
