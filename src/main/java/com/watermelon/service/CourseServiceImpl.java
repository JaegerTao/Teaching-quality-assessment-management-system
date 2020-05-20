package com.watermelon.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public List<Course> listCourse(int startPage, int pageSize) {
        Page<Course> page = new Page<>(startPage,pageSize);
        return courseMapper.listCourse(page);
    }

    @Override
    public List<Course> listCourseByClassId(int startPage, int pageSize,int classId) {
        Page<Course> page = new Page<>(startPage,pageSize);
        return courseMapper.listCourseByClassId(page,classId);
    }

    @Override
    public List<Course> listCourseWithoutTeacher(int startPage, int pageSize) {
        Page<Course> page = new Page<>(startPage,pageSize);
        return courseMapper.listCourseWithoutTeacher(page);
    }

    @Override
    public List<Course> searchCourse(int startPage, int pageSize, String str) {
        Page<Course> page = new Page<>(startPage,pageSize);
        return courseMapper.searchCourse(page,str);
    }

    @Override
    public int addCourse(Course course) {
        course.setId(courseMapper.getMaxCourseId()+1);
        return courseMapper.addCourse(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseMapper.updateCourse(course);
    }

    @Override
    public void deleteCourse(int id) {
        //由于课程在class_course表中有外键约束，因此需要先删除class_course表中的course记录
        courseMapper.deleteClassCourse(id);
        courseMapper.deleteCourse(id);
    }

    @Override
    public int getMaxCourseId() {
        return courseMapper.getMaxCourseId();
    }
}
