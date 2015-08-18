/**
 * Copyright (c) 2015. Liroyd. All rights reserved.
 */

package com.market.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("logoutSuccess")
public class LogoutSuccessController {

    @RequestMapping(method = RequestMethod.GET)
    public String formFarewellMessage(ModelMap model) {
        model.addAttribute("farewellMessage", "You have been logged out successfully. Bye bye...");
        return "security/logoutSuccess";
    }
}
