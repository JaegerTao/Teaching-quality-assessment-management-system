package com.watermelon.mapper;

import com.watermelon.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PermissionMapper {

    Permission getPermissionById(int id);

    Permission getPermissionByName(String name);

    List<Permission> listPermission();

    void addPermission(Permission permission);

    void updatePermission(Permission permission);

    void deletePermission(int id);

    Integer getPermissionNumber();

    int getMaxPermissionId();
}
