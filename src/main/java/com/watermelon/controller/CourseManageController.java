package com.watermelon.controller;

import com.watermelon.entity.Course;
import com.watermelon.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courseManage")
public class CourseManageController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/addCourse")
    public Map<String, String> addCourse(Course course){
        courseService.addCourse(course);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","delete course succeed");
        return map;
    }

    @PostMapping("/updateCourse")
    public Map<String, String> updateCourse(Course course){
        courseService.updateCourse(course);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","delete course succeed");
        return map;
    }

    @PostMapping("/deleteCourse/{id}")
    public Map<String, String> deleteCourse(@RequestParam int id){
        courseService.deleteCourse(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","delete course succeed");
        return map;
    }

    @GetMapping("/listCourse")
    public List<Course> listCourse(){
        List<Course> list = courseService.listCourse();
        return list;
    }

}
