package com.watermelon.controller;

import com.watermelon.entity.Permission;
import com.watermelon.entity.Role;
import com.watermelon.entity.User;
import com.watermelon.service.PermissionService;
import com.watermelon.service.RoleService;
import com.watermelon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam User user){
        userService.updateUser(user);
        return "";
    }

    @RequestMapping("/addRole")
    public String addRole(){

        return "";
    }

    @GetMapping("/listRole")
    public List<Role> listRole(){
        return roleService.listRole();
    }

    @GetMapping("/listPerms")
    public List<Permission> listPermission(){
        return permissionService.listPermission();
    }

}
