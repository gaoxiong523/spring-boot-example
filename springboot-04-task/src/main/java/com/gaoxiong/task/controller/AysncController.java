package com.gaoxiong.task.controller;

import com.gaoxiong.task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoxiong
 * @ClassName AysncController
 * @Description TODO
 * @date 2018/10/20 21:28
 */
@RestController
public class AysncController {
    @Autowired
    AsyncService asyncService;
    @GetMapping("/hello")
    public String hello() {
        asyncService.hello();
        return "success";
    }
}
