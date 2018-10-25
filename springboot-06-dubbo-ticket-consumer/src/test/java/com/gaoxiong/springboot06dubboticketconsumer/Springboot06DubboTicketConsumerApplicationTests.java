package com.gaoxiong.springboot06dubboticketconsumer;

import com.gaoxiong.springboot06dubboticketconsumer.service.TicketConsumerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot06DubboTicketConsumerApplicationTests {

    @Test
    public void contextLoads () {
    }
    @Autowired
    TicketConsumerService consumerService;

    @Test
    public void hello () {
        consumerService.hello();
    }
}
