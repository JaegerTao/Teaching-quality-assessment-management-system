package com.watermelon.service;

import com.watermelon.entity.Course;
import com.watermelon.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Course getCourseById(int id) {
        return courseMapper.getCourseById(id);
    }

    @Override
    public Course getCourseByName(String name) {
        return courseMapper.getCourseByName(name);
    }

    @Override
    public List<Course> listCourse() {
        return courseMapper.listCourse();
    }

    @Override
    public int addCourse(Course course) {
        return courseMapper.addCourse(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseMapper.updateCourse(course);
    }

    @Override
    public void deleteCourse(int id) {
        courseMapper.deleteCourse(id);
    }
}
