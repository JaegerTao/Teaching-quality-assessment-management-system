package com.watermelon.service;

import com.watermelon.entity.Permission;
import com.watermelon.entity.Role;
import com.watermelon.mapper.PermissionMapper;
import com.watermelon.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Role getRoleById(int id) {
        Role role = roleMapper.getRoleById(id);
        role.setPermissions((ArrayList<Permission>) getRolesPermissions(id));
        return role;
    }

    @Override
    public Role getRoleByName(String name) {
        Role role = roleMapper.getRoleByName(name);
        role.setPermissions((ArrayList<Permission>) getRolesPermissions(role.getId()));
        return role;
    }

    @Override
    public List<Integer> getPermissionsId(int id) {
        return roleMapper.getRolesPermissionsId(id);
    }

    @Override
    public List<Permission> getRolesPermissions(int id) {
        List<Integer> permsIds = roleMapper.getRolesPermissionsId(id);
        List<Permission> list = new ArrayList<>();
        for (Integer i : permsIds){
            list.add(permissionMapper.getPermissionById(i));
        }
        return list;
    }

    @Override
    public List<Role> listRole() {
        List<Role> list = roleMapper.listRole();
        for (Role role : list){
            role.setPermissions((ArrayList<Permission>) getRolesPermissions(role.getId()));
        }
        return list;
    }

    @Override
    public void addRole(Role role) {
        Role r = roleMapper.getRoleById(role.getId());
        if (r==null){
            roleMapper.addRole(role);
        }
    }

    @Override
    public void updateRole(Role role) {
        Role r = roleMapper.getRoleById(role.getId());
        if (r!=null){
            roleMapper.updateRole(role);
        }
    }

    @Override
    public void deleteRole(int id) {
        roleMapper.deleteRole(id);
    }

    @Override
    public void addRolePermission(int roleId, int permsId) {
        roleMapper.addRolePermission(roleId,permsId);
    }

    @Override
    public void deleteRolePermission(int permsId) {
        roleMapper.deleteRolePermission(permsId);
    }
}
