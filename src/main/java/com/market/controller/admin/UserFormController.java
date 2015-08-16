package com.market.controller.admin;

import com.market.Constants;
import com.market.model.User;
import com.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("admin")
public class UserFormController {

    @Autowired
    UserService userService;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String createNewUser(User user) {
        if (userService.isUserExists(user.getName())) {
            return null;
        }
        user = userService.createUser(user);
        return "User '"+user.getName()+"' has been successfully created!";
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(User user) {
      String name = user.getName();
        if (Constants.ADMIN_USER.equals(name)) {
            return null;
        }
        userService.deleteUser(name);
        return "User '"+ name +"' has been successfully deleted!";
    }
}
