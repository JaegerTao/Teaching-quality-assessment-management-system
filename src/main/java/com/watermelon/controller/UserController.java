package com.watermelon.controller;

import com.watermelon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 测试用方法
     */
    @GetMapping("/add")
    public String add() {
        return "/user/add";
    }

    @GetMapping("/update")
    public String update() {
        return "/user/update";
    }

    @GetMapping("/view")
    public String view() {
        return "/user/view";
    }

}
