package com.gaoxiong.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoxiong
 * @ClassName LoginController
 * @Description TODO
 * @date 2018/9/22 3:37
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @PostMapping(value = "/login")
    public String login( String username, String password, Model model, HttpSession session ) {
        System.out.println("用户名是:" +username);
        System.out.println("密码是:" + password);
        if (username.equals("admin") && password.equals("123456")) {
            //登陆成功,防止表单重复提交,可以重定向到主页
            session.setAttribute("username",username );
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "密码错误");
            return "login";
        }


    }
}
