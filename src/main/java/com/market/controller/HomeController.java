/**
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */
package com.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Home Controller.
 *
 * @author Alex Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
@Controller
@RequestMapping("/")
public class HomeController {
    /**
     * Controller GET /.
     * @param model Model
     * @return index jsp page name
     */
    @RequestMapping(method = RequestMethod.GET)
    public String fillParametersForWelcomePage(ModelMap model) {
        model.addAttribute("welcomeMessage", "Welcome to my Market!");
        return "index";
    }

    /**
     * Controller GET /{name}.
     * @param name Name
     * @param model Model
     * @return index jsp page name
     */
    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public String putSacredMessage(@PathVariable String name, ModelMap model) {
        model.addAttribute("welcomeMessage", name);
        return "index";
    }
}