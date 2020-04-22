package com.watermelon.service;

import com.watermelon.entity.Permission;
import com.watermelon.entity.Role;

import java.util.List;

public interface RoleService {

    Role getRoleById(int id);

    Role getRoleByName(String name);

    List<Integer> getPermissionsId(int id);

    List<Permission> getRolesPermissions(int id);

    List<Role> listRole();

}
