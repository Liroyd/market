package com.market.controller.admin;


import com.market.model.Role;
import com.market.model.User;
import com.market.service.RoleService;
import com.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminPageController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String fillParametersForAdminPage(ModelMap model, Principal principal) {
        fillParameters(model, principal);
        return "admin";
    }

    private void fillParameters(ModelMap model, Principal principal) {
        String greetingMessage = getGreetingMessage(principal);
        model.addAttribute("greetingMessage", greetingMessage);

        List<Role> roles = roleService.getRoles();
        model.addAttribute("userRoles", roles);

        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
    }

    private String getGreetingMessage(Principal principal) {
        return "Hello "+principal.getName()+". How Do You do?";
    }
}
