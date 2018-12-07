package com.globant.bootcamp.shoppingcart.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "Welcome to the Shopping Api-Rest Example for Globant Bootcamp";
    }

}