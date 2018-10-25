package com.gaoxiong.springboot06dubboticketprovider.service;

import org.springframework.stereotype.Service;

/**
 * @author gaoxiong
 * @ClassName TicketSerivceImpl
 * @Description TODO
 * @date 2018/10/21 0:07
 */
@Service
@com.alibaba.dubbo.config.annotation.Service
public class TicketSerivceImpl implements TicketService {

    @Override
    public String getTicket () {
        return "<<厉害了,我的国>>";
    }
}
