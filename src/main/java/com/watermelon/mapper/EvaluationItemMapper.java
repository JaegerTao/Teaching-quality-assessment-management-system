package com.watermelon.mapper;

import com.watermelon.entity.EvaluationItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface EvaluationItemMapper {
    EvaluationItem getEvaluationItemById(int id);
    List<EvaluationItem> getEvaluationsByRoleId(int roleId);
    int updateEvaluationItem(EvaluationItem item);
    int deleteEvaluationItem(int id);
    int insertEvaluationItem(EvaluationItem item);
}
