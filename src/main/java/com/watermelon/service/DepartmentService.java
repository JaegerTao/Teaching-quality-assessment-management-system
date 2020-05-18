package com.watermelon.service;

import com.watermelon.entity.Class;
import com.watermelon.entity.Department;

import java.util.List;

public interface DepartmentService {

    void addDepartment(Department department);

    List<Department> listDepartment(int startPage, int pageSize);

    void updateDepartment(Department department);

    void deleteDepartment(int id);

    int getMaxDepartmentId();
}
