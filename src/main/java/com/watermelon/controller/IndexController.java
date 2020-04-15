package com.watermelon.controller;

import com.watermelon.entity.User;
import com.watermelon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(){
        List<User> userList = userService.listUser();
        return "hello project";
    }
    @RequestMapping("/userList")
    public List<User> listUser(){
        List<User> list = userService.listUser();
        return list;
    }

}
