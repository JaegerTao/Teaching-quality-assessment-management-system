package com.watermelon.mapper;

import com.watermelon.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {

    public Role getRoleById(int id);

    public Role getRoleByName(String name);

    public List<Integer> getRolesPermissionsId(int id);

    public List<Role> listRole();

}
