package com.watermelon.service;

import com.watermelon.entity.Department;
import com.watermelon.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public void addDepartment(Department department) {
        department.setId(departmentMapper.getMaxDepartmentId()+1);
        departmentMapper.addDepartment(department);
    }

    @Override
    public List<Department> listDepartment() {
        return departmentMapper.listDepartment();
    }

    @Override
    public void updateDepartment(Department department) {
        departmentMapper.updateDepartment(department);
    }

    @Override
    public void deleteDepartment(int id) {
        departmentMapper.deleteDepartment(id);
    }

    @Override
    public int getMaxDepartmentId() {
        return departmentMapper.getMaxDepartmentId();
    }
}
