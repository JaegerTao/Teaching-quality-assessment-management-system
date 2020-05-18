package com.watermelon.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * id 用户id
     * name 用户名
     * password 密码
     * roleId 用户角色id(用于标记用户的角色)
     * role 用户角色(通过UserService根据roleId查询Role表获取用户角色)
     */
    private int id;
    private String name;
    private String password;
    private Integer roleId;
    private String idNumber;
    private Role role;

}