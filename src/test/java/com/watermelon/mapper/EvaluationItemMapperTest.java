package com.watermelon.mapper;

import com.watermelon.entity.EvaluationItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EvaluationItemMapperTest {
    @Autowired
    private EvaluationItemMapper evaluationItemMapper;

    @Test
    void getEvaluationsByRoleId() {
        System.out.println(evaluationItemMapper.getEvaluationsByRoleId(3));
    }

    @Test
    void getEvaluationItemById(){
        System.out.println(evaluationItemMapper.getEvaluationItemById(2));
    }

    @Test
    void updateEvaluationItem() {
        EvaluationItem evaluationItem = evaluationItemMapper.getEvaluationItemById(2);
        evaluationItem.setWeight(5000);
        evaluationItemMapper.updateEvaluationItem(evaluationItem);
    }

}