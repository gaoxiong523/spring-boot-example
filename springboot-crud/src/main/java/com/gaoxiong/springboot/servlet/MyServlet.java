package com.gaoxiong.springboot.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gaoxiong
 * @ClassName MyServlet
 * @Description TODO
 * @date 2018/10/8 22:12
 */
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet ( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        doPost(req,resp );
    }

    @Override
    protected void doPost ( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        resp.getWriter().print("hello MyServlet");
    }
}
