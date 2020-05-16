package com.watermelon.controller;

import com.watermelon.entity.*;
import com.watermelon.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SupervisorService supervisorService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody(required=false) User user) {
        userService.addUser(user);
        return "/user/add";
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody(required=false) User user){
        userService.updateUser(user);
        return "redirect:/admin/listUser";
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam(value="id",required=false) int id){
        userService.deleteUser(id);
        return "redirect:/admin/listUser";
    }

    @ResponseBody
    @GetMapping("/listUser")
    public List<User> listUser() {
        List<User> list = userService.listUser();
        return list;
    }

    @PostMapping("/addRole")
    public String addRole(@RequestBody(required=false) Role role){
        roleService.addRole(role);
        return "redirect:/admin/listRole";
    }

    @PutMapping("/updateRole")
    public String updateRole(@RequestBody(required=false) Role role){
        roleService.updateRole(role);
        return "redirect:/admin/listRole";
    }

    @DeleteMapping("/deleteRole")
    public String deleteRole(@RequestParam(value="id",required=false) int id){
        roleService.deleteRole(id);
        return "redirect:/admin/listRole";
    }

    @ResponseBody
    @GetMapping("/listRole")
    public List<Role> listRole(){
        return roleService.listRole();
    }

    @PostMapping("/addPerms")
    public String addPerms(@RequestBody(required=false) Permission permission){
        System.out.println(permission);
        permissionService.addPermission(permission);
        return "redirect:/admin/listPerms";
    }

    @PutMapping("/updatePerms")
    public String updatePerms(@RequestBody(required=false) Permission permission) {
        permissionService.updatePermission(permission);
        return "redirect:/admin/listPerms";
    }

    @DeleteMapping("/deletePerms")
    public String deletePerms(@RequestParam(value="id",required=false) int id){
        permissionService.deletePermission(id);
        return "redirect:/admin/listPerms";
    }

    @ResponseBody
    @GetMapping("/listPerms")
    public List<Permission> listPermission(){
        return permissionService.listPermission();
    }

    @PostMapping("/addSupervisor")
    public String addSupervisor(@RequestBody(required=false) Permission permission){
        System.out.println(permission);
        permissionService.addPermission(permission);
        return "redirect:/admin/listPerms";
    }

    @PutMapping("/updateSupervisor")
    public String updateSupervisor(@RequestBody(required=false) Permission permission) {
        permissionService.updatePermission(permission);
        return "redirect:/admin/listPerms";
    }

    @DeleteMapping("/deleteSupervisor")
    public String deleteSupervisor(@RequestParam(value="id",required=false) int id){
        permissionService.deletePermission(id);
        return "redirect:/admin/listPerms";
    }

    @ResponseBody
    @GetMapping("/listSupervisor")
    public List<Supervisor> listSupervisor(){
        return supervisorService.listSupervisor();
    }

    @PostMapping("/addTeacher")
    public String addTeacher(@RequestBody(required=false) Teacher teacher){
        teacherService.addTeacher(teacher);
        return "redirect:/admin/listPerms";
    }

    @PutMapping("/updateTeacher")
    public String updateTeacher(@RequestBody(required=false) Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return "redirect:/admin/listPerms";
    }

    @DeleteMapping("/deleteTeacher")
    public String deleteTeacher(@RequestParam(value="id",required=false) int id){
        teacherService.deleteTeacher(id);
        return "redirect:/admin/listPerms";
    }

    @ResponseBody
    @GetMapping("/listTeacher")
    public List<Teacher> listTeacher(){
        return teacherService.listTeacher();
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody(required=false) Student student){
        studentService.addStudent(student);
        return "redirect:/admin/listPerms";
    }

    @PutMapping("/updateStudent")
    public String updateStudent(@RequestBody(required=false) Student student) {
        studentService.updateStudent(student);
        return "redirect:/admin/listPerms";
    }

    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestParam(value="id",required=false) int id){
        studentService.deleteStudent(id);
        return "redirect:/admin/listPerms";
    }

    @ResponseBody
    @GetMapping("/listStudent")
    public List<Student> listStudent(){
        return studentService.listStudent();
    }

}
