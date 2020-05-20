package com.watermelon.controller;

import com.watermelon.entity.Class;
import com.watermelon.service.ClassService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/classe")
public class ClassController {

    @Autowired
    private ClassService classService;

    @ApiOperation(value="添加班级(包括Department,不包括Course信息)")
    @PostMapping("/addClass")
    public Map<String, String> addClass(@RequestBody(required=false)Class aClass){
        classService.addClass(aClass);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","添加班级成功");
        return map;
    }

    @ApiOperation(value="更新班级信息(包括Department,不包括Course信息)")
    @PutMapping("/updateClass")
    public Map<String, String> updateClass(@RequestBody(required=false) Class aClass){
        classService.updateClass(aClass);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","修改班级成功");
        return map;
    }

    @ApiOperation(value="删除班级(级联删除)")
    @DeleteMapping("/deleteClass/{id}")
    public Map<String, String> deleteClass(@RequestParam(value = "id",required=false) int id){
        classService.deleteClass(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","删除班级成功");
        return map;
    }

    @ApiOperation(value="为班级添加课程")
    @GetMapping("/addClassCourse")
    public Map<String, String> addClassCourse(
            @ApiParam(value="班级号",example="1") @RequestParam(value="classId",required=false) int classId,
            @ApiParam(value="课程号",example="1") @RequestParam(value="courseId",required=false) int courseId,
            @ApiParam(value="教师号",example="1") @RequestParam(value="teacherId",required=false) int teacherId){
        classService.addClassCourse(classId, courseId, teacherId);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","成功为班级添加课程");
        return map;
    }

    @ApiOperation(value="删除班级的对应课程")
    @DeleteMapping("/deleteClassCourse")
    public Map<String, String> deleteClassCourse(
            @ApiParam(value="班级号",example="1") @RequestParam(value="classId",required=false) int classId,
            @ApiParam(value="课程号",example="1") @RequestParam(value="courseId",required=false)int courseId){
        classService.deleteClassCourse(classId, courseId);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","成功删除班级的课程");
        return map;
    }

    @ApiOperation(value="获取班级列表(包括课程信息)")
    @GetMapping("/listClass")
    public List<Class> listClass(int startPage, int pageSize){
        List<Class> list = classService.listClass(startPage, pageSize);
        return list;
    }

    @ApiOperation(value="获取班级列表(不包括课程信息)")
    @GetMapping("/listClassWithNoCourse")
    public List<Class> listClassWithNoCourse(int startPage, int pageSize){
        List<Class> list = classService.listClassWithNoCourse(startPage, pageSize);
        return list;
    }


}
