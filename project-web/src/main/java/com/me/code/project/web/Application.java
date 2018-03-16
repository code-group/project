package com.me.code.project.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author zhull
 * @date 2018/3/2
 * <P>项目启动类</P>
 */
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"com.me.code.project"})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
