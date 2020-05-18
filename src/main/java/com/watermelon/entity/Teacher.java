package com.watermelon.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)  //非空才会序列化
public class Teacher extends User {

    /**
     * teacherName 教师姓名
     * gender 性别
     * region 籍贯
     * totalClass 累计授课学时
     * birth 出生日期
     * entranceDate 入职日期
     * jobTitle 职称
     * grantDate 职称授予时间
     * politicalStatus 政治面貌
     * degree 学历
     * graduateSchool 毕业院校
     */
    private String departmentName;
    private Integer gender;
    private String region;
    private Integer totalClass;
    private Date birth;
    private Date entranceDate;
    private String jobTile;
    private Date grantDate;
    private String politicalStatus;
    private String degree;
    private String graduateSchool;

    /**
     * 通过一个登录的User构造出Teacher
     * @param user User
     */
    public Teacher(User user){
        super.setId(user.getId());
        super.setName(user.getName());
        super.setPassword(user.getPassword());
        super.setRoleId(user.getRoleId());
        super.setRole(user.getRole());
    }

}
