package com.watermelon.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.watermelon.entity.Course;
import com.watermelon.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

    Department getDepartmentById(int id);

    Department getDepartmentByName(String name);

    void addDepartment(Department department);

    List<Department> listDepartment(Page<Course> page);

    void updateDepartment(Department department);

    void deleteDepartment(int id);

    int getMaxDepartmentId();
}
