/*
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */

package com.market.controller;

import com.market.Constants;
import com.market.service.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Users Personal Page Controller.
 *
 * @author Alex Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
@Controller
public class UsersPersonalPageController {

    @Autowired
    private UserService userService;

    /**
     * Controller GET /personalPage.
     * @param model Model
     * @param principal Current user
     * @return Personal page of user or admin page
     */
    @RequestMapping(value = "personalPage", method = RequestMethod.GET)
    public String redirectToPersonalPage(ModelMap model, Principal principal) {
        if (principal != null && this.userService.hasRole(principal.getName(), Constants.ADMIN_ROLE)) {
            return "redirect:/admin/";
        }
        fillGreetingMessageForPersonalPage(model, principal);
        return "personalPage";
    }

    /**
     * Fill greeting message.
     * @param model Model
     * @param principal Current user
     */
    public void fillGreetingMessageForPersonalPage(ModelMap model, Principal principal) {
        String greetingMessage = "Hello " + getUserName(principal) + ". What's up?";
        model.addAttribute("greetingMessage", greetingMessage);
    }

    /**
     * Get user name.
     * @param principal Current user
     * @return User name
     */
    private String getUserName(Principal principal) {
        if (principal != null) {
            return principal.getName();
        } else {
            return "User";
        }
    }
}
