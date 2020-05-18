package com.watermelon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supervisor extends User {

    private int id;
    private Integer gender;
    private String name;

    /**
     * 通过一个登录的User构造出Supervisor
     * @param user User
     */
    public Supervisor(User user){
        super.setId(user.getId());
        super.setName(user.getName());
        super.setPassword(user.getPassword());
        super.setRoleId(user.getRoleId());
        super.setRole(user.getRole());
    }

    /**
     * 通过一个User完善Supervisor的信息
     * @param user User
     */
    public void addUserInfo(User user){
        super.setPassword(user.getPassword());
        super.setRoleId(user.getRoleId());
        super.setRole(user.getRole());
        super.setIdNumber(user.getIdNumber());
    }

}
