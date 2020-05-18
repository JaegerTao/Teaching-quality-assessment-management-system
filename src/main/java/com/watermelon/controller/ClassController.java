package com.watermelon.controller;

import com.watermelon.entity.Class;
import com.watermelon.service.ClassService;
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

    @PostMapping("/addClass")
    public Map<String, String> addClass(@RequestBody(required=false)Class classe){
        classService.addClass(classe);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","add classe succeed");
        return map;
    }

    @PutMapping("/updateClass")
    public Map<String, String> updateClass(@RequestBody(required=false) Class classe){
        classService.updateClass(classe);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","update classe succeed");
        return map;
    }


    @DeleteMapping("/deleteClass/{id}")
    public Map<String, String> deleteClass(@RequestParam(value = "id",required=false) int id){

        classService.deleteClass(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","delete classe succeed");
        return map;
    }
    @DeleteMapping("/deleteCCourse/{id}")
    public Map<String, String> deleteCCourse(@RequestParam(value = "id",required=false) int id){

        classService.deleteCCourse(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","delete classe_course succeed");
        return map;
    }

    @GetMapping("/listClass")
    public List<Class> listClass(){
        List<Class> list = classService.listClass();
        return list;
    }


}
