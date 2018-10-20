package com.gaoxiong.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author gaoxiong
 * @ClassName AsyncService
 * @Description TODO
 * @date 2018/10/20 21:27
 */
@Service
public class AsyncService {

    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中!");
    }
}
