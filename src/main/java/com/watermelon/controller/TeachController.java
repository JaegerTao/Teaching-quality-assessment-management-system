package com.watermelon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeachController {

    @RequestMapping({"/admin"})
    public String index() {
        return "index";
    }

    @GetMapping("/")
    public String toLogin() {
        return "login";
    }

}
