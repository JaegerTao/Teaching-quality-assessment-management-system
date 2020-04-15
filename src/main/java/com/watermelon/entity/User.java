package com.watermelon.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private String password;

}