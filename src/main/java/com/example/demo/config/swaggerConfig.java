package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: apple
 * @Description: swagger2 配置
 * @Date: 2020/2/15 上午11:02
 */
@Configuration
@EnableSwagger2
public class swaggerConfig {
    /**
     * apiInfo  设置文档说明
     * select   设置swagger
     *              生效条件apis  RequestHandlerSelectors
     *                        .basePackage("com.example.demo")-》扫描的包
     *                        .withClassAnnotation(RestController.class)含有RestController注解的类
     *                       .withMethodAnnotation(GetMapping.class) 含有GetMapping注解的方法
     *             过滤路径
     *                      PathSelectors.ant("com.example.demo")
     *                                   .regex   正则
     *
     *
     * @return
     */
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("测试组")
                .apiInfo(apiInfo())
        		.globalOperationParameters(Collections.singletonList(
                        new ParameterBuilder()
                                .name("Authorization")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(true)
                                .hidden(true)
                                .defaultValue("Bearer ")
                                .build()
                        )
                )
                .select()
                //生效条件
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
//                .paths(PathSelectors.none())
                .build();

    }

    /**
     * 作者信息
     * @return
     */
    private ApiInfo apiInfo(){
        Contact contact = new Contact("MENGXIANGING", "", "1619002088@qq.com");
        return new ApiInfo("我的API文档",
                "In me the tiger sniffs the rose",
                "1.0", "urn:tos",
                contact, "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
