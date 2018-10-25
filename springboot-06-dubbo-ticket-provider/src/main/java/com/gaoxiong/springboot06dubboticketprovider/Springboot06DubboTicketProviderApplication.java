package com.gaoxiong.springboot06dubboticketprovider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.gaoxiong.springboot06dubboticketprovider.service")
public class Springboot06DubboTicketProviderApplication {

    public static void main ( String[] args ) {
        SpringApplication.run(Springboot06DubboTicketProviderApplication.class, args);
    }
}
