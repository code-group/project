package com.me.code.project.web.config;

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
 * @author zhull
 * @date 2018/3/20
 * <P>配置Swagger</P>
 * 访问地址，项目路径+swagger-ui.html
 * http://localhost:8080/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * 通过createRestApi函数创建Docket的Bean;
     * apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）;
     * select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现;
     * 本例采用指定扫描的包路径来定义，Swagger会扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）。
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.me.code.project.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("api文档")
                .description("项目案例")
                .termsOfServiceUrl("https://github.com/code-group/project")
                .contact(new Contact("ali", "https://www.jianshu.com/u/bff80bf4ba26", "zhull_julie@163.com"))
                .version("1.0.0")
                .build();
    }


}
