package com.watermelon.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SupervisorCourseMapperTest {
    @Autowired
    SupervisorCourseMapper supervisorCourseMapper;

    @Test
    void addSupervisorCourse() {
        supervisorCourseMapper.addSupervisorCourse(13,5,2);
    }

    @Test
    void deleteSupervisorCourse() {
        supervisorCourseMapper.deleteSupervisorCourse(13,5,2);
    }
}