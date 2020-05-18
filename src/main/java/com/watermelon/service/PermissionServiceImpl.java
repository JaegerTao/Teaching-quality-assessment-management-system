package com.watermelon.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.watermelon.entity.Course;
import com.watermelon.entity.Permission;
import com.watermelon.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Permission getPermissionById(int id) {
        return permissionMapper.getPermissionById(id);
    }

    @Override
    public Permission getPermissionByName(String name) {
        return permissionMapper.getPermissionByName(name);
    }

    @Override
    public List<Permission> listPermission(int startPage, int pageSize) {
        Page<Course> page = new Page<>(startPage,pageSize);
        return permissionMapper.listPermission(page);
    }

    @Override
    public void addPermission(Permission permission) {
        int number = permissionMapper.getMaxPermissionId();
        permission.setId(number+1);
        permissionMapper.addPermission(permission);
    }

    @Override
    public void updatePermission(Permission permission) {
        Permission permission1 = permissionMapper.getPermissionById(permission.getId());
        if (permission1!=null) {
            permissionMapper.updatePermission(permission);
        }
    }

    @Override
    public void deletePermission(int id) {
        Permission permission1 = permissionMapper.getPermissionById(id);
        if (permission1!=null) {
            permissionMapper.deletePermission(id);
        }
    }

    @Override
    public int getMaxPermissionId() {
        return permissionMapper.getMaxPermissionId();
    }
}
