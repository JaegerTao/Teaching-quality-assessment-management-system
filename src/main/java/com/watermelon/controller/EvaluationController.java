package com.watermelon.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.watermelon.entity.Course;
import com.watermelon.entity.IndividualEvaluation;
import com.watermelon.entity.User;
import com.watermelon.service.EvaluationService;
import com.watermelon.service.UserService;
import com.watermelon.utils.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;
    @Autowired
    private UserService userService;

    //获取可评价的课程
//    @GetMapping("/teacher/courses")
//    public Object findCoursesOfTeacher(HttpSession session){
//        Object username = session.getAttribute("username");
//        User user = userService.getUserByName((String) username);
//        return ResultUtil.success(evaluationService.getCoursesByTeacherId(user.getId()));
//    }

    @GetMapping("teacher/courses")
    public Object findCoursesOfTeacher(int startPage, int pageSize,HttpSession session){
        Object username = session.getAttribute("username");
        User user = userService.getUserByName((String) username);
        return ResultUtil.success(evaluationService.getCoursesByTeacherId(user.getId(),startPage,pageSize));
    }

    @GetMapping("/courses/byStudentId")
    public Object findCoursesByStuId(int id){
        return ResultUtil.success(evaluationService.getCoursesByStuId(id));
    }

    @GetMapping("/courses/byStudentId/withPage")
    public Object findCoursesByStuId(int id,int startPage, int pageSize){
        return ResultUtil.success(evaluationService.getCoursesByStuId(id,startPage,pageSize));
    }

    @GetMapping("/courses/bySuperId")
    public Object findTeachersBySuperId(int id){
        return ResultUtil.success(evaluationService.getCoursesBySuperId(id));
    }

    @GetMapping("/courses/bySuperId/withPage")
    public Object findTeachersBySuperId(int id,int startPage, int pageSize){
        return ResultUtil.success(evaluationService.getCoursesBySuperId(id,startPage,pageSize));
    }
//获取个人评价
    @GetMapping("/superIndividualEvaluation")
    public Object findSuperIndividualEvaluation(int superId,int teacherId, int courseId){
        return ResultUtil.success(evaluationService.getSuperIndiEvaluation(superId,teacherId,courseId));
    }

    @GetMapping("/teacherIndividualEvaluation")
    public Object findTeacherIndividualEvaluation(int fromTeacherId,int toTeacherId,int courseId){
        return ResultUtil.success(evaluationService.getTeacherIndiEvaluation(fromTeacherId,toTeacherId,courseId));
    }

    @GetMapping("/studentIndividualEvaluation")
    public Object findStudentIndividualEvaluation(int studentId,int teacherId,int courseId){
        return ResultUtil.success(evaluationService.getStudentIndiEvaluation(studentId,teacherId,courseId));
    }
//插入个人评价
    @PostMapping("/studentIndividualEvaluation")
    public Object addStudentIndividualEvaluation(@RequestBody @Valid IndividualEvaluation individualEvaluation){
        individualEvaluation.setTotalScore(((double)(individualEvaluation.getScore1() + individualEvaluation.getScore2() + individualEvaluation.getScore3() + individualEvaluation.getScore4() + individualEvaluation.getScore5() + individualEvaluation.getScore6())/6));
        evaluationService.addStudentIndiEvaluation(individualEvaluation);
        return ResultUtil.success();
    }

    @PostMapping("/teacherIndividualEvaluation")
    public Object addTeacherIndividualEvaluation(@RequestBody @Valid IndividualEvaluation individualEvaluation){
        individualEvaluation.setTotalScore(((double)(individualEvaluation.getScore1() + individualEvaluation.getScore2() + individualEvaluation.getScore3() + individualEvaluation.getScore4() + individualEvaluation.getScore5() + individualEvaluation.getScore6())/6));
        evaluationService.addTeacherIndiEvaluation(individualEvaluation);
        return ResultUtil.success();
    }

    @PostMapping("/superIndividualEvaluation")
    public Object addSuperIndividualEvaluation(@RequestBody @Valid IndividualEvaluation individualEvaluation){
        individualEvaluation.setTotalScore(((double)(individualEvaluation.getScore1() + individualEvaluation.getScore2() + individualEvaluation.getScore3() + individualEvaluation.getScore4() + individualEvaluation.getScore5() + individualEvaluation.getScore6())/6));
        evaluationService.addSuperIndiEvaluation(individualEvaluation);
        return ResultUtil.success();
    }
// 获取教师总评价
    @GetMapping("/summaryEvaluation/byTeacherId")
    public Object findSummaryEvaluation(int teacherId,int courseId){
        return ResultUtil.success(evaluationService.getSummaryEvaluation(teacherId,courseId));
    }
}
