package com.market.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/accessDenied/")
public class AccessDeniedController {

    @RequestMapping(method = RequestMethod.GET)
    public String formFarewellMessage(ModelMap model) {
        model.addAttribute("accessDeniedMessage", "Sorry... You don't have permission!");
        return "security/accessDenied";
    }
}
