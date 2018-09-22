package com.gaoxiong.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author gaoxiong
 * @ClassName MyMvcConfig
 * @Description TODO
 * @date 2018/9/22 15:28
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers ( ViewControllerRegistry registry ) {
        //添加视图映射
        registry.addViewController("/login").setViewName("login");
    }

    @Bean//两种配置视图解析器的方法
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer(){
            @Override
            public void addViewControllers ( ViewControllerRegistry registry ) {
                registry.addViewController("/").setViewName("/index");
            }

        };
        return webMvcConfigurer;
    }
}

