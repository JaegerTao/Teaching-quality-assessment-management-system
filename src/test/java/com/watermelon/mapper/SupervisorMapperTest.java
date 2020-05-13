package com.watermelon.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SupervisorMapperTest {
    @Autowired
    SupervisorMapper supervisorMapper;

    @Test
    void getAllSupervisor() {
        supervisorMapper.getAllSupervisor();
    }

}