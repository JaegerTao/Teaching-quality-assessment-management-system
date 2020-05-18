package com.watermelon.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.watermelon.entity.*;
import com.watermelon.mapper.DepartmentMapper;
import com.watermelon.mapper.RoleMapper;
import com.watermelon.mapper.TeacherMapper;
import com.watermelon.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private RoleService roleService;

    @Override
    public Teacher getTeacherById(int id) {
        Teacher teacher = teacherMapper.getTeacherById(id);
        User u = userMapper.getUserById(id);
        if (u!=null){
            teacher.addUserInfo(u);
        }
        return teacher;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacher.setId(teacherMapper.getMaxUserId()+1);
        userMapper.addUser(toUser(teacher));
        teacherMapper.addTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        userMapper.updateUser(toUser(teacher));
        teacherMapper.updateTeacher(teacher);
    }

    @Override
    public void deleteTeacher(int id) {
        teacherMapper.deleteTeacher(id);
        userMapper.deleteUser(id);
    }

    @Override
    public List<Teacher> listTeacher(int startPage, int pageSize) {
        Page<Course> page = new Page<>(startPage,pageSize);
        List<Teacher> list = teacherMapper.listTeacher(page);
        for (Teacher t : list){
            User u = userMapper.getUserById(t.getId());
            if (u!=null){
                t.addUserInfo(u);
                Role r = roleService.getRoleById(t.getRoleId());
                if (r!=null){
                    t.setRole(r);
                }
            }
        }
        return list;
    }

    /**
     * 将Teacher转换为User便于存储和管理
     * @return user User
     */
    public User toUser(Teacher teacher){
        User user = new User();
        user.setId(teacher.getId());
        user.setName(teacher.getName());
        user.setPassword(teacher.getPassword());
        user.setRoleId(teacher.getRole().getId());
        user.setRole(teacher.getRole());
        user.setIdNumber(teacher.getIdNumber());
        return user;
    }
}
