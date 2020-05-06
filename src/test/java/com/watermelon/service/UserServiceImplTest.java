package com.watermelon.service;

import com.watermelon.mapper.EvaluationItemMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;
    @Test
    void encodeMD5() {
        System.out.println(userService.encodeMD5("1234567"));
    }
    @Test
    void encodeMD5Salt() {
        System.out.println(userService.encodeMD5Salt("123456","罗老师"));
    }
}