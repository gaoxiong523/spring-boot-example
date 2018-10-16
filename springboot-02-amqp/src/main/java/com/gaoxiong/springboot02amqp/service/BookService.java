package com.gaoxiong.springboot02amqp.service;

import com.gaoxiong.springboot02amqp.bean.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author gaoxiong
 * @ClassName BookService
 * @Description TODO
 * @date 2018/10/16 23:23
 */
@Service
public class BookService {

    @RabbitListener(queues = "gaoxiong.news")
    public void receive( Book book ){
        System.out.println("收到消息"+book);
    }
}
