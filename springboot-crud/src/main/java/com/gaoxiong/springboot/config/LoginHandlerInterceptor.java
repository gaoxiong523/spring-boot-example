package com.gaoxiong.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gaoxiong
 * @ClassName LoginHandlerIntercepter
 * @Description 登陆状态拦截器检查
 * @date 2018/9/24 14:52
 */
@Configuration
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle ( HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
        Object username = request.getSession().getAttribute("username");
        if (username == null) {
            request.setAttribute("msg","你还没有登陆" );
            request.getRequestDispatcher("/login").forward(request,response );
            return false;
        } else {
            return true;
        }
    }
}
