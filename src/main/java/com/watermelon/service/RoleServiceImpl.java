package com.watermelon.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.watermelon.entity.Course;
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
    public List<Role> listRole(int startPage, int pageSize) {
        Page<Role> page = new Page<>(startPage,pageSize);
        List<Role> list = roleMapper.listRole(page);
        for (Role role : list){
            role.setPermissions((ArrayList<Permission>) getRolesPermissions(role.getId()));
        }
        return list;
    }

    @Override
    public void addRole(Role role) {
        int number = roleMapper.getMaxRoleId();
        List<Permission> list = role.getPermissions();
        if (list!=null){
            for (Permission perms : list){
                roleMapper.addRolePermission(role.getId(),perms.getId());
            }
        }
        role.setId(number+1);
        roleMapper.addRole(role);
    }

    @Override
    public void updateRole(Role role) {
        Role r = roleMapper.getRoleById(role.getId());
        if (r!=null){
            roleMapper.updateRole(role);
            //删除role_permission表中此角色的所有权限并重新添加
            roleMapper.deleteAllRolePermission(role.getId());
            List<Permission> list = role.getPermissions();
            if (list!=null){
                for (Permission perms : list){
                    roleMapper.addRolePermission(role.getId(),perms.getId());
                }
            }
        }
    }

    @Override
    public void deleteRole(int id) {
        List<Integer> permsIds = roleMapper.getRolesPermissionsId(id);
        for (int i : permsIds){
            roleMapper.deleteRolePermission(id,i);
        }
        roleMapper.deleteRole(id);
    }

    @Override
    public void addRolePermission(int roleId, int permsId) {
        roleMapper.addRolePermission(roleId,permsId);
    }

    @Override
    public void deleteRolePermission(int roleId,int permsId) {
        roleMapper.deleteRolePermission(roleId,permsId);
    }

    @Override
    public int getMaxRoleId() {
        return roleMapper.getMaxRoleId();
    }
}
