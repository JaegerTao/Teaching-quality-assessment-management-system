package com.watermelon.controller;

import com.watermelon.entity.Supervisor;
import com.watermelon.service.SupervisorService;
import com.watermelon.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupervisorController {

    @Autowired
    SupervisorService supervisorService;

    @GetMapping("/supervisors")
    public Object getAllSupervisor(){
        return ResultUtil.success(supervisorService.getAllSupervisor());
    }

    // 设置督导可评价的课程
    @PostMapping("/supervisorCourse")
    public Object addSupervisorCourse(int supervisorId, int courseId, int teacherId){
        supervisorService.addSupervisorCourse(supervisorId,courseId,teacherId);
        return ResultUtil.success();
    }
    @DeleteMapping("/supervisorCourse")
    public Object deleteSupervisorCourse(int supervisorId, int courseId, int teacherId){
        supervisorService.deleteSupervisorCourse(supervisorId,courseId,teacherId);
        return ResultUtil.success();
    }
}
