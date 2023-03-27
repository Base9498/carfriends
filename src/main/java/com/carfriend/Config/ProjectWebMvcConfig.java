package com.carfriend.Config;

import com.carfriend.Config.interceptor.ProjectInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ProjectWebMvcConfig implements WebMvcConfigurer {
    /**
     * 配置跨域请求头
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOrigins("*");
    }

    /**
     * 拦截请求范围
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ProjectInterceptor())
                .addPathPatterns("/**")//拦截所有请求
                .excludePathPatterns("/login/**");//开放登录路径
    }

}
