package com.watermelon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {

    private int id;
    private Department department;
    private String number;
    private String name;
    private String grade;
    private List<Course> courseList;
}
