/**
 * Copyright (c) 2015, Liroyd
 * All rights reserved.
 */
package com.market.controller;

import com.market.model.Product;
import com.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Market Controller.
 *
 * @author Alex Liroyd (Alex_Lioryd@yahoo.com)
 * @version $Id$
 */
@Controller
@RequestMapping("market")
public class MarketController {
    /**
     * Product service.
     */
    @Autowired
    private ProductService productService;

    /**
     * Controller GET /market.
     * @param model Model
     * @return market jsp page name
     */
    @RequestMapping(method = RequestMethod.GET)
    public String fillParametersForAdminPage(ModelMap model) {
        model.addAttribute("marketTitle", "You can see our stuff:)");
        List<Product> products = this.productService.getProducts();
        model.addAttribute("products", products);
        return "market";
    }
}
