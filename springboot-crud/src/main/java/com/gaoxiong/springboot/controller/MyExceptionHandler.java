package com.gaoxiong.springboot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoxiong
 * @ClassName MyExceptionHandler
 * @Description TODO
 * @date 2018/9/29 0:09
 */
@ControllerAdvice
public class MyExceptionHandler {


    //这种处理方式浏览器和客户端返回的都是json
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String ,Object> handlerException( Exception e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "错误编码");
        map.put("message",e.getMessage() );
        return map;
    }

    //自适应方式
    @ExceptionHandler(Exception.class)
    public String handlerExceptionAuto( Exception e, HttpServletRequest request ) {
        HashMap<String, Object> map = new HashMap<>();
        //传入自定义的错误状态码, 4xx,5xx
        request.setAttribute("javax.servlet.error.status-code", 400);
        map.put("code", "错误编码");
        map.put("message",e.getMessage() );
        //转发到/error
        return "forward:/error";
    }
}
