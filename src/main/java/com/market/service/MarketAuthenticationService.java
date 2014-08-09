package com.market.service;

import com.market.dao.UserDAO;
import com.market.model.Role;
import com.market.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Service
@Transactional(readOnly=true)
public class MarketAuthenticationService implements UserDetailsService {

    private UserDAO userDAO;

    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
        User user = userDAO.getUser(login);
        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                getAuthorities(user.getRoles())
        );
    }

    public Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
