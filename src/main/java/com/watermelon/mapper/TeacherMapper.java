package com.watermelon.mapper;

import com.watermelon.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {

    Teacher getTeacherById(int id);

    void addTeacher(Teacher teacher);

    void addTeacherDept(int id,int deptId);

    void updateTeacher(Teacher teacher);

    void deleteTeacher(int id);

    int getMaxTeacherId();

    List<Teacher> listTeacher();
}
