package com.watermelon.service;

import com.watermelon.entity.Role;
import com.watermelon.entity.Student;
import com.watermelon.entity.User;
import com.watermelon.mapper.StudentMapper;
import com.watermelon.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleService roleService;

    @Override
    public Student getStudentById(int id) {
        Student student = studentMapper.getStudentById(id);
        User u = userMapper.getUserById(id);
        if (u!=null){
            student.addUserInfo(u);
        }
        return student;
    }

    @Override
    public void addStudent(Student student) {
        student.setId(studentMapper.getMaxStudentId()+1);
        userMapper.addUser(toUser(student));
        studentMapper.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentMapper.deleteStudent(id);
    }

    @Override
    public List<Student> listStudent() {
        List<Student> list = studentMapper.listStudent();
        for (Student s : list){
            User u = userMapper.getUserById(s.getId());
            if (u!=null){
                s.addUserInfo(u);
                Role r = roleService.getRoleById(s.getRoleId());
                if (r!=null){
                    s.setRole(r);
                }
            }
        }
        return list;
    }

    /**
     * 将Student转换为User便于存储和管理
     * @return user User
     */
    public User toUser(Student student){
        User user = new User();
        user.setId(student.getId());
        user.setName(student.getName());
        user.setPassword(student.getPassword());
        user.setRoleId(student.getRoleId());
        user.setIdNumber(student.getIdNumber());
        return user;
    }

}
