package com.cupk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/food")
    public String showFoodPage() {
        return "food";
    }

@GetMapping("/attraction")
public String showAttractionPage() {
    return "attraction";
    }
}
