package com.watermelon.mapper;

import com.watermelon.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

    void addDepartment(Department department);

    List<Department> listDepartment();

    void updateDepartment(Department department);

    void deleteDepartment(int id);
}
