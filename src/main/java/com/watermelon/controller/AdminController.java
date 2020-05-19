package com.watermelon.controller;

import com.watermelon.entity.*;
import com.watermelon.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SupervisorService supervisorService;

    @PostMapping("/addUser")
    public Map<String,String> addUser(@RequestBody(required=false) User user) {
        userService.addUser(user);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","添加用户成功");
        return map;
    }

    @PutMapping("/updateUser")
    public Map<String, String> updateUser(@RequestBody(required=false) User user){
        userService.updateUser(user);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","修改用户成功");
        return map;
    }

    @DeleteMapping("/deleteUser")
    public Map<String, String> deleteUser(@RequestParam(value="id",required=false) int id){
        userService.deleteUser(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","删除用户成功");
        return map;
    }

    @ResponseBody
    @GetMapping("/listUser")
    public List<User> listUser(int startPage, int pageSize) {
        List<User> list = userService.listUser(startPage, pageSize);
        return list;
    }

    @PostMapping("/addRole")
    public Map<String, String> addRole(@RequestBody(required=false) Role role){
        roleService.addRole(role);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","添加角色成功");
        return map;
    }

    @PutMapping("/updateRole")
    public Map<String, String> updateRole(@RequestBody(required=false) Role role){
        roleService.updateRole(role);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","修改角色成功");
        return map;
    }

    @DeleteMapping("/deleteRole")
    public Map<String, String> deleteRole(@RequestParam(value="id",required=false) int id){
        roleService.deleteRole(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","删除角色成功");
        return map;
    }

    @ResponseBody
    @GetMapping("/listRole")
    public List<Role> listRole(int startPage, int pageSize){
        return roleService.listRole(startPage, pageSize);
    }

    @PostMapping("/addPerms")
    public Map<String, String> addPerms(@RequestBody(required=false) Permission permission){
        permissionService.addPermission(permission);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","添加权限成功");
        return map;
    }

    @PutMapping("/updatePerms")
    public Map<String, String> updatePerms(@RequestBody(required=false) Permission permission) {
        permissionService.updatePermission(permission);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","修改权限成功");
        return map;
    }

    @DeleteMapping("/deletePerms")
    public Map<String, String> deletePerms(@RequestParam(value="id",required=false) int id){
        permissionService.deletePermission(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","删除权限成功");
        return map;
    }

    @ResponseBody
    @GetMapping("/listPerms")
    public List<Permission> listPermission(int startPage, int pageSize){
        return permissionService.listPermission(startPage, pageSize);
    }

    @PostMapping("/addSupervisor")
    public Map<String, String> addSupervisor(@RequestBody(required=false) Supervisor supervisor){
        supervisorService.addSupervisor(supervisor);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","添加督导成功");
        return map;
    }

    @PutMapping("/updateSupervisor")
    public Map<String, String> updateSupervisor(@RequestBody(required=false) Supervisor supervisor) {
        supervisorService.updateSupervisor(supervisor);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","修改督导成功");
        return map;
    }

    @DeleteMapping("/deleteSupervisor")
    public Map<String, String> deleteSupervisor(@RequestParam(value="id",required=false) int id){
        supervisorService.deleteSupervisor(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","删除督导成功");
        return map;
    }

    @ResponseBody
    @GetMapping("/listSupervisor")
    public List<Supervisor> listSupervisor(int startPage, int pageSize){
        return supervisorService.listSupervisor(startPage, pageSize);
    }

    @PostMapping("/addTeacher")
    public Map<String, String> addTeacher(@RequestBody(required=false) Teacher teacher){
        teacherService.addTeacher(teacher);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","添加教师成功");
        return map;
    }

    @PutMapping("/updateTeacher")
    public Map<String, String> updateTeacher(@RequestBody(required=false) Teacher teacher) {
        teacherService.updateTeacher(teacher);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","修改教师成功");
        return map;
    }

    @DeleteMapping("/deleteTeacher")
    public Map<String, String> deleteTeacher(@RequestParam(value="id",required=false) int id){
        teacherService.deleteTeacher(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","删除教师成功");
        return map;
    }

    @ResponseBody
    @GetMapping("/listTeacher")
    public List<Teacher> listTeacher(int startPage, int pageSize){
        return teacherService.listTeacher(startPage, pageSize);
    }

    @PostMapping("/addStudent")
    public Map<String, String> addStudent(@RequestBody(required=false) Student student){
        studentService.addStudent(student);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","添加学生成功");
        return map;
    }

    @PutMapping("/updateStudent")
    public Map<String, String> updateStudent(@RequestBody(required=false) Student student) {
        studentService.updateStudent(student);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","修改学生成功");
        return map;
    }

    @DeleteMapping("/deleteStudent")
    public Map<String, String> deleteStudent(@RequestParam(value="id",required=false) int id){
        studentService.deleteStudent(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","删除学生成功");
        return map;
    }

    @GetMapping("/listStudentWithNoCourse")
    public List<Student> listStudentWithNoCourse(int startPage, int pageSize){
        return studentService.listStudentWithNoCourse(startPage, pageSize);
    }

    @GetMapping("/listStudent")
    public List<Student> listStudent(int startPage, int pageSize){
        return studentService.listStudent(startPage, pageSize);
    }

    @GetMapping("/listStudentByClassId")
    public List<Student> listStudentByClassId(int startPage, int pageSize,int classId){
        return studentService.listStudentByClassId(startPage, pageSize, classId);
    }

    @PostMapping("/addAdmin")
    public Map<String,String> addAdmin(@RequestBody(required=false) Admin admin){
        adminService.addAdmin(admin);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","添加管理员成功");
        return map;
    }

    @PutMapping("/updateAdmin")
    public Map<String,String> updateAdmin(@RequestBody(required=false) Admin admin){
        adminService.updateAdmin(admin);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","修改管理员成功");
        return map;
    }

    @DeleteMapping("/deleteAdmin")
    public Map<String,String> deleteAdmin(@RequestParam(value="id",required=false) int id){
        adminService.deleteAdmin(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("message","删除管理员成功");
        return map;
    }

}
