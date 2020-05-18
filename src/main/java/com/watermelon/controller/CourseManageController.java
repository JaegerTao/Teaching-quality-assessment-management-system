package com.watermelon.controller;

import com.watermelon.entity.Course;
import com.watermelon.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Map<String, String> addCourse(@RequestBody(required=false) Course course){
        courseService.addCourse(course);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","delete course succeed");
        return map;
    }

    @PutMapping("/updateCourse")
    public Map<String, String> updateCourse(@RequestBody(required=false) Course course){
        courseService.updateCourse(course);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","delete course succeed");
        return map;
    }

    @DeleteMapping("/deleteCourse/{id}")
    public Map<String, String> deleteCourse(@RequestParam(value="id",required=false) int id){
        courseService.deleteCourse(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","delete course succeed");
        return map;
    }

    @ResponseBody
    @GetMapping("/listCourse")
    public List<Course> listCourse(int startPage, int pageSize){
        List<Course> list = courseService.listCourse(startPage, pageSize);
        return list;
    }

    @ResponseBody
    @GetMapping("/listCourseByClassId")
    public List<Course> listCourseByClassId(int startPage, int pageSize,int classId){
        List<Course> list = courseService.listCourseByClassId(startPage, pageSize, classId);
        return list;
    }

    @ResponseBody
    @GetMapping("/listCourseWithNoTeacher")
    public List<Course> listCourseWithoutTeacher(int startPage, int pageSize){
        List<Course> list = courseService.listCourseWithoutTeacher(startPage, pageSize);
        return list;
    }

}
