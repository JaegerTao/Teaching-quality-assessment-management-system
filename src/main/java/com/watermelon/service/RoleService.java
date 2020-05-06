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

    void addRole(Role role);

    void updateRole(Role role);

    void deleteRole(int id);

    void addRolePermission(int roleId,int permsId);

    void deleteRolePermission(int roleId,int permsId);

}
