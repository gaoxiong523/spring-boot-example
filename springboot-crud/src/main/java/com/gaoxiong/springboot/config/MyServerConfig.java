package com.gaoxiong.springboot.config;

import com.gaoxiong.springboot.filter.MyFilter;
import com.gaoxiong.springboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Arrays;

/**
 * @author gaoxiong
 * @ClassName MyServerConfig
 * @Description TODO
 * @date 2018/10/8 22:15
 */
@Configuration
public class MyServerConfig {

    //注册三大组件
    @Bean
    public ServletRegistrationBean servletRegistrationBean () {
        ServletRegistrationBean<MyServlet> myServletServletRegistrationBean = new ServletRegistrationBean<>(new MyServlet(), "/myservlet");
        return myServletServletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean () {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new MyFilter());
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myservlet"));
        return filterFilterRegistrationBean;
    }

    
}
