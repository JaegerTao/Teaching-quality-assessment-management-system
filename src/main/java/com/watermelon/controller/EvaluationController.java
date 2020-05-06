package com.watermelon.controller;

import com.watermelon.service.EvaluationService;
import com.watermelon.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;

    @GetMapping("/teachers/byTeacherId")
    public Object findTeachersByTeacherId(int id){
        return ResultUtil.successJson(evaluationService.getTeachersByTeacherId(id));
    }

    @GetMapping("/courses/byStudentId")
    public Object findCoursesByStuId(int id){
        return ResultUtil.successJson(evaluationService.getCoursesByStuId(id));
    }

    @GetMapping("/teachers/bySuperId")
    public Object findTeachersBySuperId(int id){
        return ResultUtil.successJson(evaluationService.getTeachersBySuperId(id));
    }
}
