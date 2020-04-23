package com.watermelon.mapper;

import com.watermelon.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {

    Course getCourseById(int id);

    Course getCourseByName(String name);

    List<Course> listCourse();

    int addCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(int id);

}
