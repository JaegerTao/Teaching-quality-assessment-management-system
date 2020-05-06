package com.watermelon.service;

import com.alibaba.fastjson.JSONObject;
import com.watermelon.entity.EvaluationItem;

import java.util.List;

public interface EvaluationItemService {
    /**
     * 查询对应角色的评价列表
     * @param rid
     * @return
     */
    List<EvaluationItem> findList(int rid);

    /**
     * 修改评价项
     * @param evaluationItem
     * @return
     */
    int updateEvaluatinItem(EvaluationItem evaluationItem);

    /**
     * 插入评价项
     * @param evaluationItem
     * @return
     */
    int insertEvaluationItem(EvaluationItem evaluationItem);

    /**
     * 删除评价项
     * @param id
     * @return
     */
    int deleteEvaluationItem(int id);

    /**
     * 获取所有角色对应的评价列表
     * @return
     */
    JSONObject findLists();
}
