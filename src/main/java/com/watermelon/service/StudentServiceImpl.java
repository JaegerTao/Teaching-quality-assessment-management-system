package com.watermelon.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.watermelon.entity.Class;
import com.watermelon.entity.Course;
import com.watermelon.entity.Role;
import com.watermelon.entity.Student;
import com.watermelon.entity.User;
import com.watermelon.mapper.CourseMapper;
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

    @Autowired
    private CourseMapper courseMapper;

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
        student.setId(studentMapper.getMaxUserId()+1);
        userMapper.addUser(toUser(student));
        studentMapper.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        userMapper.updateUser(toUser(student));
        studentMapper.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentMapper.deleteStudent(id);
        userMapper.deleteUser(id);
    }

    @Override
    public List<Student> listStudentWithNoCourse(int startPage, int pageSize) {
        Page<Course> page = new Page<>(startPage,pageSize);
        List<Student> list = studentMapper.listStudentWithNoCourse(page);
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

    @Override
    public List<Student> listStudent(int startPage, int pageSize) {
        List<Student> list = studentMapper.listStudentWithNoCourse(new Page<>(startPage,pageSize));
        for (Student s : list){
            User u = userMapper.getUserById(s.getId());
            if (u!=null){
                s.addUserInfo(u);
                Role r = roleService.getRoleById(s.getRoleId());
                if (r!=null){
                    s.setRole(r);
                }
            }
            Class aClass = s.getAClass();
            if (aClass!=null){
                int classId = aClass.getId();
                List<Course> courseList =  courseMapper.listCourseByClassId(classId);
                s.setCourseList(courseList);
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
        user.setRoleId(student.getRole().getId());
        user.setRole(student.getRole());
        user.setIdNumber(student.getIdNumber());
        return user;
    }

}
