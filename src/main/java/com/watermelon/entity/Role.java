package com.watermelon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private int id;
    private String name;
    private ArrayList<Permission> permissions = new ArrayList<>();

}
