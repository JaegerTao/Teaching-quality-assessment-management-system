package com.watermelon.controller;

import com.watermelon.entity.User;
import com.watermelon.mapper.UserMapper;
import com.watermelon.service.UserService;
import com.watermelon.service.UserServiceImpl;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping({"/"})
    public String index() {
        return "index";
    }

    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,@RequestParam String password, Model model) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        model.addAttribute("username",username);

//        System.out.println(userService.encodeMD5(password));

        try {
            //登陆以后进入UserRealm类doGetAuthenticationInfo方法进行认证
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名错误!");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误!");
            return "login";
        } catch (Exception e) {
            e.printStackTrace();
            return "login";
        }
    }

    @GetMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,@RequestParam String password,@RequestParam String rePassword,Model model){
        if (!password.equals(rePassword)){
            model.addAttribute("msg", "两次输入密码不一致!");
            return "register";
        }
        userService.registerUser(username,password);
        return "redirect:toLogin";
    }

    @GetMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:toLogin";
    }

    @ResponseBody
    @GetMapping("/noAuth")
    public String noAuth() {
        return "未经授权，无法访问该页面！";
    }

}
