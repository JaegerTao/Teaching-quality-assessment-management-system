package com.watermelon.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.watermelon.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EvaluationMapperTest {

    @Autowired
    EvaluationMapper evaluationMapper;

    @Test
    void getSummaryEvaluation() {
        System.out.println(evaluationMapper.getSummaryEvaluation(5,5));
    }

    @Test
    void getCourses(){
        Page<Course> p = new Page<>();
        System.out.println(evaluationMapper.getCoursesOfTeacher(2,p));
    }

    @Test
    void getAdvice(){
        Page<String> p = new Page<>();
        System.out.println(evaluationMapper.getAdvices(5,1,3,p));
    }
}