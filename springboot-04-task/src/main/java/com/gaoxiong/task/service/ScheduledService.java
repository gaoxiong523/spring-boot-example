package com.gaoxiong.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author gaoxiong
 * @ClassName ScheduledService
 * @Description TODO
 * @date 2018/10/20 21:35
 */
@Service
public class ScheduledService {

    @Scheduled(cron = "0/4 * * * * ?")
    public void scheduled(){
        System.out.println("定时任务..."+System.currentTimeMillis());
    }
}
