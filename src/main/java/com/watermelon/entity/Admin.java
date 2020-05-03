package com.watermelon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User{

    /**
     * gender 性别
     * tel 联系电话
     */
    private int gender;
    private String tel;

    /**
     * 通过一个User构造出Admin
     * @param user User
     */
    public Admin(User user){
        super.setId(user.getId());
        super.setName(user.getName());
        super.setPassword(user.getPassword());
        super.setRoleId(user.getRoleId());
        super.setRole(user.getRole());
    }

}
