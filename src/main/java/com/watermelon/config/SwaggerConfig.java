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
