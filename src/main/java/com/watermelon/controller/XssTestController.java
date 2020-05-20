package com.watermelon.controller;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XssTestController {
    @GetMapping("/testXss")
    public String testXss(String name) {
        return "--输入的内容为--：" + name;
    }
}
