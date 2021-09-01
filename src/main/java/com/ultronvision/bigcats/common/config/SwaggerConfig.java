package com.ultronvision.bigcats.common.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author oldwei
 * @date 2021-8-27 14:29
 */
@Configuration
@EnableKnife4j
@EnableSwagger2
@ConditionalOnClass(Docket.class)
public class SwaggerConfig {
    private static final String VERSION = "1.0";

    @Value("${springfox.swagger2.enabled}")
    private Boolean swaggerEnabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerEnabled)
                .groupName("SwaggerDemo")
                .apiInfo(apiInfo())
                .select()
                //这里通过.apis(...)标明给加上@Api注解的类自动生成接口文档。
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //扫描接口的包
                //.apis(RequestHandlerSelectors.basePackage("com.ultronvision.bigcats.modules.cats.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 添加摘要信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .contact(new Contact("大猫", "https://bigcats.oldwei.com", "172965909@qq.com"))
                .description("swagger接口文档")
                .version(VERSION)
                .build();
    }
}
