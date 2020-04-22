package com.watermelon.config;

import com.watermelon.entity.User;
import com.watermelon.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {
        System.out.println("授权Authorization");

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        info.addStringPermission(null);
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证Authentication");
        //获取登录用户的信息
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        User user = userService.getUserByName(userToken.getUsername());
        //当用户名不匹配时返回null,shiro自动抛出UnknownAccountException异常
        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getName()), getName());
    }
}
