package com.watermelon.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.watermelon.entity.Class;
import com.watermelon.entity.Course;
import com.watermelon.mapper.ClassMapper;
import com.watermelon.mapper.CourseMapper;
import com.watermelon.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClassServiceImpl implements ClassService{

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private ClassMapper classMapper;

    @Override
    public Class getClassById(int id) {
        return classMapper.getClassById(id);
    }

    @Override
    public Class getClassByName(String name) {
        return classMapper.getClassByName(name);
    }

    @Override
    public List<Class> listClassWithNoCourse(int startPage, int pageSize) {
        Page<Class> page = new Page<>(startPage,pageSize);
        return classMapper.listClass(page);
    }

    @Override
    public List<Class> listClass(int startPage, int pageSize) {
        Page<Class> page = new Page<>(startPage,pageSize);
        List<Class> list = classMapper.listClass(page);
        //通过班级号获取课程班级课程并添加至courseList
        for (Class c : list){
            List<Course> courseList = courseMapper.listCourseByClassId(c.getId());
            c.setCourseList(courseList);
        }
        return list;
    }

    @Override
    public int addClass(Class aClass) {
        aClass.setId(classMapper.getMaxClassId()+1);
        return classMapper.addClass(aClass);
    }

    @Override
    public void updateClass(Class aClass) {
       classMapper.updateClass(aClass);
    }

    @Override
    public void deleteClass(int id) {
        //删除class_course中的class
        classMapper.deleteClassFromClassCourse(id);
        classMapper.deleteClass(id);
    }

    /**
     * 为班级添加课程
     * @param classId
     * @param courseId
     */
    @Override
    public void addClassCourse(int classId,int courseId, int teacherId) {
        classMapper.addClassCourse(classId, courseId, teacherId);
    }

    /**
     * 删除班级已经选中的课程
     * @param classId
     * @param courseId
     */
    @Override
    public void deleteClassCourse(int classId,int courseId) {
        classMapper.deleteClassCourse(classId, courseId);
    }

    @Override
    public int getMaxClass() {
        return classMapper.getMaxClassId();
    }
}
