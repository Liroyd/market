package com.market.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    @RequestMapping(method = RequestMethod.GET)
    public String fillParametersForAdminPage(ModelMap model) {
        model.addAttribute("adminGreeting", "How do you do Admin?");
        return "admin";
    }
}
