package com.watermelon.controller;

import com.watermelon.entity.User;
import com.watermelon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 测试用方法
     */
    @GetMapping("/add")
    public String add() {
        return "/user/add";
    }

    @GetMapping("/update")
    public String update() {
        return "/user/update";
    }

    @GetMapping("/view")
    public String view() {
        return "/user/view";
    }

    //找回密码
    @GetMapping("/findPWD")
    public String findALL(HttpServletRequest request){
        //获取session
        HttpSession session = request.getSession();
        //获取用户输入id
        String username = request.getParameter("username");
        //获取用户输入的身份证
        String idnumber = request.getParameter("idnumber");
        //用户输入的新密码
        String newpwd = request.getParameter("newpwd");
        //确认新密码
        String comfirmpwd = request.getParameter("comfirmpwd");
        //根据名字获得用户
        User sysUser = userService.getUserByName(username);
        if (idnumber.equals(sysUser.getIdNumber())&&username.equals(sysUser.getName())&&newpwd.equals(comfirmpwd)) {
            sysUser.setPassword(newpwd);
            //如果输入原密码正确就修改密码
            userService.updateUser(sysUser);
            session.setAttribute("result","true");
            return "main";
        } else {
            //如果不存在提示密码不正确
            session.setAttribute("result","false");
        }
        return "reset-password";

    }

    //修改密码
    @GetMapping("/updatePWD")
    public String updatePWD(HttpServletRequest request,HttpSession session) {
        //获取session
        HttpSession session1 = request.getSession();
        //获取用户输入的原密码
        String oldpwd = request.getParameter("oldpwd");
        //用户输入的新密码
        String newpwd = request.getParameter("newpwd");
        //确认新密码
        String comfirmpwd = request.getParameter("comfirmpwd");
        //根据名字获得用户
        String username = (String) session.getAttribute("username");
        User sysUser = userService.getUserByName(username);
        //获得用户加密后的原密码
        String password2 = sysUser.getPassword();
        if (password2.equals(newpwd)&&newpwd.equals(comfirmpwd)) {
            sysUser.setPassword(newpwd);
            //如果输入原密码正确就修改密码
            userService.updateUser(sysUser);
            session1.setAttribute("result","true");
            return "main";
        } else {
            //如果不存在提示密码不正确
            session1.setAttribute("result","false");
        }
        return "update-password";
    }

}
