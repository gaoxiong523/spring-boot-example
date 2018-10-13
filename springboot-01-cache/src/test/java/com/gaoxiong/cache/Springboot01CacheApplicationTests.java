package com.gaoxiong.cache;

import com.gaoxiong.cache.entity.Employee;
import com.gaoxiong.cache.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Springboot01CacheApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate; //操作的K-V都是对象的
    @Autowired
    private StringRedisTemplate stringRedisTemplate; //操作的K-V都是字符串的
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     *  1.string
     *  2. list
     *  3.set
     *  4.hash
     *  5.zset(有序集合)
     */
    @Test
    public void contextLoads () {
    }

    @Test
    public void testRedisString(){
        redisTemplate.opsForValue().set("testkey","redis 简单测试" );
        Object testkey = redisTemplate.opsForValue().get("testkey");
        log.info("测试的redis:"+testkey.toString());
    }
    @Test
    public void testRedisString2(){
        stringRedisTemplate.opsForValue().set("testkey","redis 简单测试" );
        Object testkey = redisTemplate.opsForValue().get("testkey");
        log.info("测试的redis:"+testkey.toString());
    }
    @Test
    public void testEmp(){
        //默认如果保存对象,使用jdk序列化机制,序列化后的数据保存到redis中
        Employee one = employeeRepository.getOne(2);
        redisTemplate.opsForValue().set("emp-02",one );
    }

    @Test
    public void testRedisList(){
        ListOperations listOperations = redisTemplate.opsForList();
    }
    @Test
    public void testRedisSet(){
        redisTemplate.opsForSet();
    }
    @Test
    public void testRedisHash(){
        redisTemplate.opsForHash();
    }
    @Test
    public void testRedisZSet(){
        redisTemplate.opsForZSet();
    }

}
