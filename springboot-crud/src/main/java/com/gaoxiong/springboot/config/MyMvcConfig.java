package com.gaoxiong.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

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

    @Override
    public void addInterceptors ( InterceptorRegistry registry ) {
        //注册拦截器
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login.html","/index/html","/user/login","/login");
    }

    @Bean//两种配置视图解析器的方法
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer(){
            @Override
            public void addViewControllers ( ViewControllerRegistry registry ) {
                registry.addViewController("/").setViewName("/index");
                registry.addViewController("/main.html").setViewName("/dashboard");
            }

        };
        return webMvcConfigurer;
    }



}

