package com.gaoxiong.springboot02amqp;

import com.gaoxiong.springboot02amqp.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02AmqpApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void contextLoads () {
        amqpAdmin.declareExchange(new DirectExchange("admin.exchange"));
        amqpAdmin.declareQueue(new Queue("admin"));
        amqpAdmin.declareBinding(new Binding("admin.exchange",Binding.DestinationType.QUEUE ,"admin.exchange" , "admin.haha", null));
    }

    @Test
    public void test() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个单播消息");
        map.put("datas",Arrays.asList("xiaoxi",123,true));
        rabbitTemplate.convertAndSend("exchange.direct","gaoxiong.news" ,map );

    }

    @Test
    public void receive () {
        Object o = rabbitTemplate.receiveAndConvert("gaoxiong.news");
        System.out.println(o);
    }

    @Test
    public void send(){
        rabbitTemplate.convertAndSend("exchange.fanout","gaoxiong.news" ,new Book("三国演绎","罗贯中" ));
        rabbitTemplate.convertAndSend("exchange.fanout","gaoxiong.news" ,new Book("红楼梦","曹雪娇" ));
    }
}
