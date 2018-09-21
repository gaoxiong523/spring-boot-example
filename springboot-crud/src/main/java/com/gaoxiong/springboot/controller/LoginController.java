package com.gaoxiong.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author gaoxiong
 * @ClassName LoginController
 * @Description TODO
 * @date 2018/9/22 3:37
 */
@Controller
public class LoginController {

    @PostMapping(value = "/login")
    public String login(String username,String password) {
        System.out.println("用户名是:" +username);
        System.out.println("密码是:" + password);
        return "list";
    }
}
