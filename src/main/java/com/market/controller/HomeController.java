/**
 * Copyright (c) 2015. Liroyd. All rights reserved.
 */

package com.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String fillParametersForWelcomePage(ModelMap model) {
        model.addAttribute("welcomeMessage", "Welcome to my Market!");
        return "index";
    }

    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public String putSacredMessage(@PathVariable String name, ModelMap model) {
        model.addAttribute("welcomeMessage", name);
        return "index";
    }
}