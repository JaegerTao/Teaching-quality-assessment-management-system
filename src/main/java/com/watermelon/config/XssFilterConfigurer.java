package com.watermelon.config;


import com.watermelon.utils.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:xss过滤拦截器配置文件
 */
@Configuration
public class XssFilterConfigurer {

    /**
     * xss过滤拦截器
     */
    @Bean
    public FilterRegistrationBean xssFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        //设置过滤器
        filterRegistrationBean.setFilter(new XssFilter());
        filterRegistrationBean.setOrder(Integer.MAX_VALUE-1);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        Map<String, String> initParameters = new HashMap();
        //excludes用于配置不需要参数过滤的请求url
        initParameters.put("excludes", "/favicon.ico,/img/*,/js/*,/css/*");
        initParameters.put("isIncludeRichText", "true");
        filterRegistrationBean.setInitParameters(initParameters);
        return filterRegistrationBean;
    }
}

