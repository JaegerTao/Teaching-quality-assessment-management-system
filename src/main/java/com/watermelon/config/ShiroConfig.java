package com.watermelon.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro配置类
 * 配置Shiro的权限访问逻辑，对url进行过滤并验证身份和访问权限
 * Realm UserRealm
 * 加密方式 MD5加密
 * 映射次数 1
 * 盐值 默认未开启
 * 版本 2.0
 * 日期 2020/4/22
 */
@Configuration
public class ShiroConfig {

    //通过Spring对UserRealm对象进行托管
    @Bean(name = "userRealm")
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        Map<String, String> filterMap = new LinkedHashMap<String, String>();

        filterMap.put("/user/add", "perms[user:add]");
        filterMap.put("/user/update", "perms[user:update]");
        filterMap.put("/user/view", "perms[user:view]");
        filterMap.put("/admin/*", "perms[user:add]");

        //usr路径下的所有页面都进行验证拦截
        filterMap.put("/user/*", "authc");
        //设置拦截路径和拦截方式，用户访问包含在filterMap中的任何路径都会进行其相应的验证
        bean.setFilterChainDefinitionMap(filterMap);
        //设置登录url,当没有验证时默认跳转至登陆页面
        bean.setLoginUrl("/toLogin");
        //设置未验证时跳转至noAuth页面
        bean.setUnauthorizedUrl("/noAuth");

        return bean;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");// 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(1);// 散列的次数，比如散列两次，相当于md5(md5(""));
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);//表示是否存储散列后的密码为16进制，需要和生成密码时的一样，默认是base64；
        return hashedCredentialsMatcher;
    }

}
