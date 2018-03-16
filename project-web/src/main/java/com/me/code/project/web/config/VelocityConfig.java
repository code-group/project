package com.me.code.project.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;

import java.util.Properties;

/**
 * @author zhull
 * @date 2018/3/16
 * <P>Velocity配置</P>
 */
@Configuration
public class VelocityConfig {

    @Bean
    public VelocityLayoutViewResolver velocityLayoutViewResolver() {
        VelocityLayoutViewResolver bean = new VelocityLayoutViewResolver();
        // 返回x.vm模板，：将a.vm模板的内容填充layout页面的$screen_content占位符的内容，然后再将整个填充后的页面返回给用户
        bean.setLayoutUrl("layout/default.vm");
        bean.setCache(false);
        bean.setSuffix(".vm");
        bean.setExposeSpringMacroHelpers(true);
        bean.setRequestContextAttribute("rc");
        bean.setDateToolAttribute("dateTool");
        bean.setNumberToolAttribute("numberTool");
        bean.setContentType("text/html;charset=UTF-8");
        bean.setToolboxConfigLocation("/WEB-INF/toolbox.xml");
        return bean;
    }

    @Bean
    public VelocityConfigurer velocityConfigurer() {
        VelocityConfigurer bean = new VelocityConfigurer();
        bean.setResourceLoaderPath("/WEB-INF/vm/");
        Properties properties = new Properties();
        properties.setProperty("input.encoding", "UTF-8");
        properties.setProperty("output.encoding", "UTF-8");
        properties.setProperty("contentType", "text/html;charset=UTF-8");
        bean.setVelocityProperties(properties);
        return bean;
    }
}
