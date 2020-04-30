package com.watermelon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    /**
     * id 角色id
     * name 角色名称
     * permissions 角色权限列表(此字段通过RoleService读取数据库Permission表添加)
     */
    private int id;
    private String name;
    private ArrayList<Permission> permissions = new ArrayList<>();

}
