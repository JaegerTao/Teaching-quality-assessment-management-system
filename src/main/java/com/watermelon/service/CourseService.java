package com.watermelon.service;

import com.watermelon.entity.Course;

import java.util.List;

public interface CourseService {

    Course getCourseById(int id);

    Course getCourseByName(String name);

    List<Course> listCourse();

    int addCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(int id);

    int getMaxCourseId();
}
