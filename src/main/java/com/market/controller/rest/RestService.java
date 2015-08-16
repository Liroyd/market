package com.market.controller.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class RestService {

    @RequestMapping(method = RequestMethod.GET)
    public String greeting() {
        return "It's alive!";
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String greeting(@PathVariable String name) {
        return "Hello "+name;
    }
}
