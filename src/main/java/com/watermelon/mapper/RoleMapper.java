package com.watermelon.mapper;

import com.watermelon.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {

    Role getRoleById(int id);

    Role getRoleByName(String name);

    List<Integer> getRolesPermissionsId(int id);

    List<Role> listRole();

    void addRole(Role role);

    void updateRole(Role role);

    void deleteRole(int id);

    void addRolePermission(int roleId,int permsId);

    void deleteRolePermission(int permsId);



}
