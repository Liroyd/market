/*
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */

package com.common.security;

import com.market.dao.UserDAO;
import com.market.model.Role;
import com.market.model.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring Market Authentication Service, implementation of UserDetailsService.
 *
 * @author Alex Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
@Service
@Transactional(readOnly = true)
public class MarketAuthenticationService implements UserDetailsService {
    /**
     * UserDAO.
     */
    @Autowired
    private UserDAO userDAO;

    /**
     * Load user by username.
     * @param login User login
     * @return User details
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
        User user = this.userDAO.getUser(login);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getName(),
                    user.getPassword(),
                    true,
                    true,
                    true,
                    true,
                    this.getAuthorities(user.getRoles())
            );
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    /**
     * Get authorities.
     * @param roles User roles
     * @return Authorities
     */
    public Collection<? extends GrantedAuthority> getAuthorities(final Set<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(roles.size());
        for (final Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
}
