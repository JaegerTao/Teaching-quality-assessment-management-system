package com.watermelon.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.watermelon.entity.Course;
import com.watermelon.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {

    Student getStudentById(int id);

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(int id);

    int getMaxUserId();

    List<Student> listStudentWithNoCourse();

    List<Student> listStudentWithNoCourse(Page<Course> page);

    List<Student> listStudentByClassId(Page<Course> page,int classId);

    List<Student> searchStudent(Page<Course> page,String str);

}
