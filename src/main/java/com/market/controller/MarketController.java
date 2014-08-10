package com.market.controller;

import com.market.model.Product;
import com.market.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("market")
public class MarketController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping(method = RequestMethod.GET)
    public String fillParametersForAdminPage(ModelMap model) {
        model.addAttribute("marketTitle", "You can see our stuff:)");
        List<Product> products = productsService.getProducts();
        model.addAttribute("products", products);
        return "market";
    }
}
