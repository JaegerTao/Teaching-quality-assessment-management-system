package com.watermelon.service.elasticsearch;

import com.watermelon.entity.UserBehavior;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserBehaviorServiceTest {
    @Autowired
    UserBehaviorService userBehaviorService;

    @Test
    void addBehavior() throws IOException, ParseException {
        UserBehavior userBehavior = new UserBehavior();
        userBehavior.setId(14);
        userBehavior.setModule("授课管理");
        userBehavior.setSubModule("课程管理");
        userBehavior.setOperate("删除");
        userBehaviorService.addBehavior(userBehavior);
    }
}