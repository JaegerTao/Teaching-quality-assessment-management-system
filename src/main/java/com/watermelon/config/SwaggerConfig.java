package com.watermelon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Swagger配置类
 * 设置扫描接口的范围和接口文档页面的相关信息并动态生成API文档
 * 扫描范围 com.watermelon.controller包下的所有类的所有方法
 * API文档访问路径 /swagger-ui.html
 * 开启方式 application.yml -> switch-swagger-up: true
 * 默认状态 开启
 * 版本 1.0
 * 日期 2020/5/3
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${switch-swagger-up}")
    private Boolean switchUp;

    /**
     * apiInfo()设置接口文档基本信息
     * enable()swagger功能开关
     * select().apis()配置接口扫描策略
     * @return Docket
     */
    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .enable(switchUp)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.watermelon.controller"))
                .build();
    }

    /**
     * 配置接口文档基本信息
     * @return ApiInfo
     */
    private ApiInfo getApiInfo(){
        return new ApiInfo("教学评分管理系统 Api文档",
                "Api文档有点难搞嗷", "1.0",
                "urn:tos",
                 new Contact("Watermelon","www.watermelonzx.cn","guess what"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                 new ArrayList<VendorExtension>());
    }

}
