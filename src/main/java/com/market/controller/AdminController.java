package com.market.controller;


import com.market.dao.RoleDAO;
import com.market.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    private RoleDAO roleDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String fillParametersForAdminPage(ModelMap model, Principal principal) {
        String greetingMessage = getGreetingMessage(principal);
        model.addAttribute("greetingMessage", greetingMessage);

        List<Role> roles = roleDAO.getRoles();
        model.addAttribute("userRoles", roles);
        model.addAttribute("userName", "");

        return "admin";
    }

    private String getGreetingMessage(Principal principal) {
        return "Hello "+principal.getName()+". How Do You do?";
    }
}
