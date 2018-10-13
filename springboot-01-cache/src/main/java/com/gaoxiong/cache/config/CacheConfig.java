package com.gaoxiong.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author gaoxiong
 * @ClassName CacheConfig
 * @Description TODO
 * @date 2018/10/13 12:53
 */
@Configuration
public class CacheConfig {

    @Bean(name = "myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return ( target, method, params ) -> method.getName()+"["+Arrays.asList(params) +"]";
    }
}
