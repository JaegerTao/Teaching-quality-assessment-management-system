package com.watermelon.controller;

import com.watermelon.entity.Teacher;
import com.watermelon.entity.User;
import com.watermelon.service.StudentService;
import com.watermelon.service.TeacherService;
import com.watermelon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/teacher")
public class TeachController {

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService teacherService;

    @ResponseBody
    @GetMapping("/getTeacher")
    public Teacher getTeacher(HttpSession session){
        String username = (String) session.getAttribute("username");
        User user = userService.getUserByName(username);
        return teacherService.getTeacherById(user.getId());
    }

    @PutMapping("/updateTeacher")
    public void updateTeacher(@RequestBody(required=false) Teacher teacher) {
        teacherService.updateTeacher(teacher);
    }

}
