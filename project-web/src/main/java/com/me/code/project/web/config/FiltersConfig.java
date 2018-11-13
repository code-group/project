package com.me.code.project.web.config;

import com.me.code.project.web.filters.EncodingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <P>date: 2018/11/13
 * 拦截器配置
 **/
@Configuration
public class FiltersConfig {

    @Bean
    public FilterRegistrationBean encodingFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new EncodingFilter());
        bean.addInitParameter("encoding", "UTF-8");
        bean.addUrlPatterns("/*");
        return bean;
    }
}
