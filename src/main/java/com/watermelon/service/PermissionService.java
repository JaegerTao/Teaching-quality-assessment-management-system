package com.watermelon.service;

import com.watermelon.entity.Permission;

import java.util.List;

public interface PermissionService {

    Permission getPermissionById(int id);

    Permission getPermissionByName(String name);

    List<Permission> listPermission();

}
