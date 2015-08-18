/**
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */
package com.market.controller.admin;

import com.market.model.Role;
import com.market.model.User;
import com.market.service.RoleService;
import com.market.service.UserService;
import java.security.Principal;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Admin Page Controller.
 *
 * @author Alex Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
@Controller
@RequestMapping("admin")
public class AdminPageController {
    /**
     * Role service.
     */
    @Autowired
    private RoleService roleService;
    /**
     * User service.
     */
    @Autowired
    private UserService userService;

    /**
     * Controller GET /admin.
     * @param model MVC model
     * @param principal Current user
     * @return admin jsp page name
     */
    @RequestMapping(method = RequestMethod.GET)
    public String fillParametersForAdminPage(ModelMap model, Principal principal) {
        fillParameters(model, principal);
        return "admin";
    }

    /**
     * Fill model with parameters.
     * @param model MVC model
     * @param principal Current user
     */
    private void fillParameters(ModelMap model, Principal principal) {
        String greetingMessage = getGreetingMessage(principal);
        model.addAttribute("greetingMessage", greetingMessage);

        List<Role> roles = this.roleService.getRoles();
        model.addAttribute("userRoles", roles);

        List<User> users = this.userService.getUsers();
        removeCurrentUserFromList(principal, users);
        model.addAttribute("users", users);
    }

    /**
     * Remove current user from model for user selector.
     * @param principal Current user
     * @param users List of all users
     */
    private void removeCurrentUserFromList(Principal principal, List<User> users) {
        Iterator<User> usersIterator = users.iterator();
        while (usersIterator.hasNext()) {
            User user = usersIterator.next();
            if (user.getName().equals(principal.getName())) {
                usersIterator.remove();
            }
        }
    }

    /**
     * Prepare greeting message.
     * @param principal Current user
     * @return Greeting message
     */
    private String getGreetingMessage(Principal principal) {
        return "Hello "+principal.getName()+". How Do You do?";
    }
}
