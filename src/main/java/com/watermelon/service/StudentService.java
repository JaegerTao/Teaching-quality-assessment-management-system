package com.watermelon.service;

import com.watermelon.entity.Student;

import java.util.List;

public interface StudentService {

    Student getStudentById(int id);

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(int id);

    List<Student> listStudent();

}
