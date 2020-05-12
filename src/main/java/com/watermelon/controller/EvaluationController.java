package com.watermelon.controller;

import com.watermelon.entity.IndividualEvaluation;
import com.watermelon.service.EvaluationService;
import com.watermelon.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;
//获取可评价的课程
    @GetMapping("/courses/byTeacherId")
    public Object findCoursesByTeacherId(int id){
        return ResultUtil.successJson(evaluationService.getCoursesByTeacherId(id));
    }

    @GetMapping("/courses/byStudentId")
    public Object findCoursesByStuId(int id){
        return ResultUtil.successJson(evaluationService.getCoursesByStuId(id));
    }


    @GetMapping("/courses/bySuperId")
    public Object findTeachersBySuperId(int id){
        return ResultUtil.successJson(evaluationService.getCoursesBySuperId(id));
    }
//获取个人评价
    @GetMapping("/superIndividualEvaluation")
    public Object findSuperIndividualEvaluation(int superId,int teacherId, int courseId){
        return ResultUtil.successJson(evaluationService.getSuperIndiEvaluation(superId,teacherId,courseId));
    }

    @GetMapping("/teacherIndividualEvaluation")
    public Object findTeacherIndividualEvaluation(int fromTeacherId,int toTeacherId,int courseId){
        return ResultUtil.successJson(evaluationService.getTeacherIndiEvaluation(fromTeacherId,toTeacherId,courseId));
    }

    @GetMapping("/studentIndividualEvaluation")
    public Object findStudentIndividualEvaluation(int studentId,int teacherId,int courseId){
        return ResultUtil.successJson(evaluationService.getStudentIndiEvaluation(studentId,teacherId,courseId));
    }
//插入个人评价
    @PostMapping("/studentIndividualEvaluation")
    public Object addStudentIndividualEvaluation(@RequestBody IndividualEvaluation individualEvaluation){
        evaluationService.addStudentIndiEvaluation(individualEvaluation);
        return ResultUtil.successJson();
    }

    @PostMapping("/teacherIndividualEvaluation")
    public Object addTeacherIndividualEvaluation(@RequestBody IndividualEvaluation individualEvaluation){
        evaluationService.addTeacherIndiEvaluation(individualEvaluation);
        return ResultUtil.successJson();
    }

    @PostMapping("/superIndividualEvaluation")
    public Object addSuperIndividualEvaluation(@RequestBody IndividualEvaluation individualEvaluation){
        evaluationService.addSuperIndiEvaluation(individualEvaluation);
        return ResultUtil.successJson();
    }
}
