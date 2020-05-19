package com.watermelon.controller;

import com.watermelon.entity.User;
import com.watermelon.service.UserService;
import com.watermelon.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
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
    public Map<String,String> login(@RequestBody(required=false) User user, HttpSession session) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
        System.out.println("username:"+user.getName());
        System.out.println("password:"+user.getPassword());
        session.setAttribute("username",user.getName());
//        System.out.println(userService.encodeMD5(password));
        Map<String,String> map = new HashMap<>();
        try {
            //登陆以后进入UserRealm类doGetAuthenticationInfo方法进行认证
            subject.login(token);
            User u = userService.getUserByName(user.getName());
            map.put("status","200");
            map.put("username",u.getName());
            map.put("role_id",u.getRoleId()+"");
            return map;
        } catch (UnknownAccountException e) {
            map.put("status","401");
            map.put("massage","用户名错误!");
            return map;
        } catch (IncorrectCredentialsException e) {
            map.put("status","401");
            map.put("massage","密码错误！");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status","-1");
            map.put("massage","未知错误");
            return map;
        }
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

//    @GetMapping("/toRegister")
//    public String toRegister() {
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String register(@RequestParam(value="username",required=false) String username,@RequestParam(value="password",required=false) String password,@RequestParam(value="username",required=false) String rePassword,Model model){
//        if (!password.equals(rePassword)){
//            model.addAttribute("msg", "两次输入密码不一致!");
//            return "register";
//        }
//        userService.registerUser(username,password);
//        return "redirect:toLogin";
//    }

}
