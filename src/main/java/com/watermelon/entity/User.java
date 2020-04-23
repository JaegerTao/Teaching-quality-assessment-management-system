package com.watermelon.entity;

import lombok.*;
import org.apache.ibatis.annotations.Mapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private String password;
    private int roleId;
    private Role role;

}