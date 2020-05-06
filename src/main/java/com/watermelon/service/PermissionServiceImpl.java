package com.watermelon.service;

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
    public List<Permission> listPermission() {
        return permissionMapper.listPermission();
    }

    @Override
    public void addPermission(Permission permission) {
        Permission permission1 = permissionMapper.getPermissionById(permission.getId());
        if (permission1==null) {
            permissionMapper.addPermission(permission);
        }
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
}
