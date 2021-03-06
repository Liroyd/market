/*
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */

package com.market.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Access Denied Controller.
 * @author Alex Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
@Controller
@RequestMapping("accessDenied")
public class AccessDeniedController {
    /**
     * Security controller access denied.
     * @param model Model
     * @return security/accessDenied jsp page name
     */
    @RequestMapping(method = RequestMethod.GET)
    public String formFarewellMessage(ModelMap model) {
        model.addAttribute("accessDeniedMessage", "Sorry... You don't have permission!");
        return "security/accessDenied";
    }
}
