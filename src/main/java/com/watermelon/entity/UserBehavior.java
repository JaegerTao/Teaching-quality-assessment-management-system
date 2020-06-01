package com.watermelon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBehavior {
    Integer id;
    String module;
    String subModule;
    String operate;
    String role;
    String name;
    String username;
    String createDate;
}
