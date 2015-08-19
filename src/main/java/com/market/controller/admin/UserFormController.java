/*
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */

package com.market.controller.admin;

import com.market.Constants;
import com.market.model.User;
import com.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User Form Controller.
 *
 * @author Alex Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
@Controller
@RequestMapping("admin/user")
public class UserFormController {

    @Autowired
    private UserService userService;

    /**
     * Controller POST /admin/user.
     * @param user User
     * @return Success message or null
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String createNewUser(User user) {
        if (this.userService.isUserExists(user.getName())) {
            return null;
        }
        user = userService.createUser(user);
        return "User '" + user.getName() + "' has been successfully created!";
    }

    /**
     * Controller DELETE /admin/user.
     * @param user User
     * @return Success message or null
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(User user) {
      String name = user.getName();
        if (Constants.ADMIN_USER.equals(name)) {
            return null;
        }
        this.userService.deleteUser(name);
        return "User '" + name + "' has been successfully deleted!";
    }
}
