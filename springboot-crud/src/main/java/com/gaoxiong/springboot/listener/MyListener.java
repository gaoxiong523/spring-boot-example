package com.gaoxiong.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author gaoxiong
 * @ClassName MyListener
 * @Description TODO
 * @date 2018/10/8 22:28
 */
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized ( ServletContextEvent servletContextEvent ) {
        System.out.println("容器启动了");
    }

    @Override
    public void contextDestroyed ( ServletContextEvent servletContextEvent ) {
        System.out.println("容器销毁了");
    }
}
