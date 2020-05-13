package com.watermelon.mapper;

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
        System.out.println(evaluationMapper.getSummaryEvaluation(5));
    }
}