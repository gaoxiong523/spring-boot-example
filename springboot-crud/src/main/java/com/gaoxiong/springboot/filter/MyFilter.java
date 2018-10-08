package com.gaoxiong.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author gaoxiong
 * @ClassName MyFilter
 * @Description TODO
 * @date 2018/10/8 22:24
 */
public class MyFilter implements Filter {
    @Override
    public void init ( FilterConfig filterConfig ) throws ServletException {

    }

    @Override
    public void doFilter ( ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain ) throws IOException, ServletException {
        System.out.println("我的过滤器开始执行了");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy () {

    }
}
