package com.watermelon.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.watermelon.entity.Course;
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

    List<Role> listRole(Page<Role> page);

    void addRole(Role role);

    void updateRole(Role role);

    void deleteRole(int id);

    void addRolePermission(int roleId,int permsId);

    void deleteRolePermission(int roleId,int permsId);

    void deleteAllRolePermission(int roleId);

    Integer getRoleNumber();

    int getMaxRoleId();
}
