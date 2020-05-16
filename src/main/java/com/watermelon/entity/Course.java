package com.watermelon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    /**
     * id 课程号
     * name 课程名
     * courseType 课程类型
     * courseClass 课程类别
     * courseDept 课程开设学院
     * score 学分
     * time 学时
     */
    private int id;
    private String name;
    private String number;
    private String courseType;
    private String courseClass;
    private String courseDep;
    private float score;
    private int time;
    private Teacher teacher;

}
