package com.watermelon.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.watermelon.entity.Course;

import java.util.List;

public interface CourseService {

    Course getCourseById(int id);

    Course getCourseByName(String name);

    List<Course> listCourse(int startPage, int pageSize);

    List<Course> listCourseByClassId(int startPage, int pageSize, int classId);

    List<Course> listCourseWithoutTeacher(int startPage, int pageSize);

    List<Course> searchCourse(int startPage, int pageSize, String str);

    int addCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(int id);

    int getMaxCourseId();
}
