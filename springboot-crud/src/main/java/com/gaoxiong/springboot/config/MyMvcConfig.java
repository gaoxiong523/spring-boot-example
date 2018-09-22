package com.gaoxiong.springboot.config;

import org.springframework.context.annotation.Configuration;
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
}
