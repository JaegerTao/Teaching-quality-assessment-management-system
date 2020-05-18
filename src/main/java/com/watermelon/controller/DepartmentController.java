package com.watermelon.controller;

import com.watermelon.entity.Course;
import com.watermelon.entity.Department;
import com.watermelon.service.CourseService;
import com.watermelon.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public Map<String, String> addDepartment(@RequestBody(required=false) Department department){
        departmentService.addDepartment(department);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","add department succeed");
        return map;
    }

    @PutMapping("/updateDepartment")
    public Map<String, String> updateDepartment(@RequestBody(required=false) Department department){
        departmentService.updateDepartment(department);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","update department succeed");
        return map;
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public Map<String, String> deleteDepartment(@RequestParam(value="id",required=false) int id){
        departmentService.deleteDepartment(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","delete department succeed");
        return map;
    }

    @GetMapping("/listDepartment")
    public List<Department> listDepartment(int startPage, int pageSize){
        List<Department> list = departmentService.listDepartment(startPage, pageSize);
        return list;
    }
}
