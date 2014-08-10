package com.market.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("market")
public class MarketController {

    @RequestMapping(method = RequestMethod.GET)
    public String fillParametersForAdminPage(ModelMap model) {
        model.addAttribute("marketTitle", "You can see our stuff:)");
        return "market";
    }
}
