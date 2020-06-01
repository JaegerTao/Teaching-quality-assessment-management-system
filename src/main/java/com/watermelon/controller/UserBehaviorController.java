package com.watermelon.controller;

import com.watermelon.entity.UserBehavior;
import com.watermelon.service.elasticsearch.UserBehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;

@RestController
@RequestMapping("userBehavior")
public class UserBehaviorController {
    @Autowired
    UserBehaviorService userBehaviorService;
    @PostMapping("/add")
    public void addUserBehavior(UserBehavior userBehavior) throws IOException, ParseException {
        userBehaviorService.addBehavior(userBehavior);
    }
}
