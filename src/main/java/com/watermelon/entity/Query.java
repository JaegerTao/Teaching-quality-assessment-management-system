package com.watermelon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Query {
    String username;
    String idnumber;
    String oldpwd;
    String newpwd;
    String comfirmpwd;
}
