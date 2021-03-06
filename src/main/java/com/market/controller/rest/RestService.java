/*
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */

package com.market.controller.rest;

import com.market.model.RestEntity;
import com.market.model.Role;
import com.market.model.User;
import java.util.HashSet;
import java.util.Set;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Service.
 *
 * @author Alex Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
@RestController
@RequestMapping("/rest/")
public class RestService {

    public static final int QUANTITY = 100;

    /**
     * Rest json GET /rest/user/{name}.
     * @param name Name
     * @return User
     */
    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    public User getUserJson(@PathVariable String name) {
        Role role = new Role("lol");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        return new User(name, "Password", roles);
    }

    /**
     * Rest String GET /rest/{name}.
     * @param name Name
     * @return "Hello" + name
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String getGreeting(@PathVariable String name) {
        return "Hello " + name;
    }

    /**
     * Rest json GET /rest/json.
     * @return Rest entity
     */
    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = "application/json")
    public RestEntity getJsonRestEntity() {
        return new RestEntity("Name", RestService.QUANTITY);
    }

    /**
     * Rest json GET /rest/json/{name}.
     * @param name Name
     * @return Rest entity
     */
    @RequestMapping(value = "/json/{name}", method = RequestMethod.GET, produces = "application/json")
    public RestEntity getJsonRestEntity(@PathVariable String name) {
        return new RestEntity(name, RestService.QUANTITY);
    }

    /**
     * Rest xml GET /rest/xml.
     * @return Rest entity
     */
    @RequestMapping(value = "/xml", method = RequestMethod.GET)
    public RestEntity getXmlRestEntity() {
        return new RestEntity("Name", RestService.QUANTITY);
    }

    /**
     * Rest xml GET /rest/xml/{name}.
     * @param name Name
     * @return Rest entity
     */
    @RequestMapping(value = "/xml/{name}", method = RequestMethod.GET)
    public RestEntity getXmlRestEntity(@PathVariable String name) {
        return new RestEntity(name, RestService.QUANTITY);
    }
}
