package com.watermelon.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Druid数据连接池配置类
 * 配置连接池的监控后台登录方式以及不进行监控的文件
 * 开启方式 application.yml -> spring-datasource-type
 * 默认状态 开启
 * 初始连接 5
 * 最小连接数 5
 * 最大连接数 20
 * 防火墙 默认开启
 * 版本 1.0
 * 时间 2020/4/15
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //进入druid后台监控
    @Bean
    public ServletRegistrationBean toMonitor() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //后台登录账号密码设置
        Map initMap = new HashMap<String, String>();
        //添加配置,loginUsername及loginPassword为固定设置
        initMap.put("loginUsername", "admin");
        initMap.put("loginPassword", "123");
        //allow为空则所有用户都能访问
        initMap.put("allow", "");

        bean.setInitParameters(initMap);
        return bean;
    }

    //过滤器
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        //设置不进行统计的请求
        Map filterMap = new HashMap<String, String>();
        filterMap.put("exclusions", "*.js,*.css");
        bean.setInitParameters(filterMap);
        return bean;
    }

}
