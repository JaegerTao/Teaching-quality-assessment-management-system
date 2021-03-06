package com.watermelon.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.watermelon.entity.Course;
import com.watermelon.entity.Student;

import java.util.List;

public interface StudentService {

    Student getStudentById(int id);

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(int id);

    List<Student> listStudentWithNoCourse(int startPage, int pageSize);

    List<Student> listStudent(int startPage, int pageSize);

    List<Student> listStudentByClassId(int startPage, int pageSize,int classId);

    List<Student> searchStudent(int startPage, int pageSize, String str);

}
