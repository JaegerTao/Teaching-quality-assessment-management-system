package com.watermelon.service;

import com.watermelon.entity.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher getTeacherById(int id);

    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    void deleteTeacher(int id);

    List<Teacher> listTeacher(int startPage, int pageSize);

}
