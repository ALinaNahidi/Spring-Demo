package com.springdemo.storylab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showLoginPage(Model model) {
        return "storyLab/login-page";
    }

    @GetMapping("/access-denied")
    public String getAccessDeniedPage(){
        return "access-denied";
    }

}
