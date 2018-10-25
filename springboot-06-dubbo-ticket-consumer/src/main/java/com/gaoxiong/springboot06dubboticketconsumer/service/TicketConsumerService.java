package com.gaoxiong.springboot06dubboticketconsumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gaoxiong.springboot06dubboticketprovider.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * @author gaoxiong
 * @ClassName TicketConsumerService
 * @Description TODO
 * @date 2018/10/21 0:09
 */
@Service
public class TicketConsumerService {
    @Reference
    TicketService ticketService;

    public void hello(){
        String ticket = ticketService.getTicket();
        System.out.println("买到票了"+ticket);
    }
}
