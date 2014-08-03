package com.market.controller;

import com.market.Constants;
import com.market.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class UsersPersonalPageController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/personalPage/", method = RequestMethod.GET)
    public String redirectToPersonalPage(ModelMap model, Principal principal) {
        if (userDAO.hasRole(principal.getName(), Constants.ADMIN_ROLE)) {
            return "redirect:/admin/";
        }
        fillGreetingMessageForPersonalPage(model, principal);
        return "personalPage";
    }

    public void fillGreetingMessageForPersonalPage(ModelMap model, Principal principal) {
        String greetingMessage = "Hello "+principal.getName()+". What's up?";
        model.addAttribute("greetingMessage", greetingMessage);
    }
}
