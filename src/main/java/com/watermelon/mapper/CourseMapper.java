package com.watermelon.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.watermelon.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {

    Course getCourseById(int id);

    Course getCourseByName(String name);

    List<Course> listCourse(Page<Course> page);

    List<Course> listCourseByClassId(int classId);

    List<Course> listCourseByClassId(Page<Course> page,int classId);

    List<Course> listCourseWithoutTeacher(Page<Course> page);

    List<Course> searchCourse(Page<Course> page,String str);

    int addCourse(Course course);

    void updateCourse(Course course);

    void deleteClassCourse(int id);

    void deleteCourse(int id);

    int getMaxCourseId();
}
