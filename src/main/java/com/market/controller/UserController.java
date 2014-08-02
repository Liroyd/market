package com.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user/")
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public String fillParametersForUserPage(ModelMap model) {
        model.addAttribute("userGreeting", "Hello User!");
        return "user";
    }
}
