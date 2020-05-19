package com.watermelon.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.watermelon.entity.Class;
import com.watermelon.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClassMapper {

    Class getClassById(int id);

    Class getClassByName(String name);

    List<Class> listClass(Page<Class> page);

    int addClass(Class aClass);

    void updateClass(Class aClass);

    void deleteClass(int id);

    void addClassCourse(int classId, int courseId, int teacherId);

    void deleteClassCourse(int classId, int courseId);

    void deleteClassFromClassCourse(int classId);

    int getMaxClassId();

}
