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

    List<Class> listClass(Page<Course> page);

    int addClass(Class classe);

    void updateClass(Class classe);

    void deleteClass(int id);

    void deleteCCourse(int id);

    int getMaxClassId();

}
