package com.market.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    @RequestMapping(method = RequestMethod.GET)
    public String fillParametersForAdminPage(ModelMap model, Principal principal) {
        String greetingMessage = "Hello "+principal.getName()+". How Do You do?";
        model.addAttribute("greetingMessage", greetingMessage);
        return "admin";
    }
}
