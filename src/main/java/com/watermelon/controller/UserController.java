package com.watermelon.controller;

import com.watermelon.entity.User;
import com.watermelon.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/add")
    public String add() {
        return "/user/add";
    }

    @RequestMapping("/update")
    public String update() {
        return "/user/update";
    }

    @RequestMapping("/view")
    public String view() {
        return "/user/view";
    }

    @ResponseBody
    @GetMapping("/list")
    public List<User> listUser() {
        List<User> list = userMapper.listUser();
        for (User user : list) {
            System.out.println(user);
        }
        return list;
    }
}
