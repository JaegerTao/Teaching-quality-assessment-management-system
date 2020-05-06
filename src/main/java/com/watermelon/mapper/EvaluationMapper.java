package com.watermelon.mapper;

import com.watermelon.entity.Course;
import com.watermelon.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EvaluationMapper {
    List<Teacher> getTeachersByTeacherId(int id);
    List<Course> getCoursesByStuId(int id);
    List<Teacher> getTeachersBySuperId(int id);
}
