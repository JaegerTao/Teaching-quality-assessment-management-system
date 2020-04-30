package com.watermelon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {

    /**
     * name 权限名称
     * url 访问路径
     * perms 权限
     * type 权限类型
     */
    private int id;
    private String name;
    private String url;
    private String perms;
    private String type;

}
