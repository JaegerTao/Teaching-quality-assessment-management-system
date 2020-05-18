package com.watermelon.controller;

import com.alibaba.fastjson.JSONObject;
import com.watermelon.entity.EvaluationItem;
import com.watermelon.service.EvaluationItemService;
import com.watermelon.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluationItem")
public class EvaluationItemController {
    @Autowired
    private EvaluationItemService evaluationItemService;

    @GetMapping("/list")
    public Object findList(int rid){
        return ResultUtil.success(evaluationItemService.findList(rid));
    }
    public Object findLists(){
        return ResultUtil.success(evaluationItemService.findLists());
    }
    @PutMapping("/update")
    public Object updateEvaluationItem(@RequestBody EvaluationItem evaluationItem){
        evaluationItemService.updateEvaluatinItem(evaluationItem);
        return ResultUtil.success();
    }
    @DeleteMapping("/delete")
    public Object deleteEvaluationItem(int id){
        evaluationItemService.deleteEvaluationItem(id);
        return ResultUtil.success();
    }
    @PostMapping("/insert")
    public Object insertEvaluationItem(@RequestBody EvaluationItem evaluationItem){
        evaluationItemService.insertEvaluationItem(evaluationItem);
        return ResultUtil.success();
    }
}
