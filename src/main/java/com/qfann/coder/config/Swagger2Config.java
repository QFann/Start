package com.qfann.coder.config;

import org.springframework.beans.factory.annotation.Value;
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
 * Created by qifan on 2018/8/26.
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {
    //是否开启swagger，正式环境一般需要关闭的，可根据springboot的多环境配置进行设置
    @Value(value = "${swagger.enabled}")
    Boolean swaggerEnable;

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                //是否开启
                .enable(swaggerEnable).select()
                //扫描的路径包
                .apis(RequestHandlerSelectors.basePackage("com.qfann.coder"))
                //指定路径处理PathSelectors.any()代表所有路径
                .paths(PathSelectors.any()).build().pathMapping("/");
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("springBoot-Swagger2集成和使用Demo示例")
                .description("qfann|qfann")
                .contact(new Contact("qfann","http://127.0.0.1","yourEmail@xxx.com"))
                .version("1.0.0").build();
    }
}
