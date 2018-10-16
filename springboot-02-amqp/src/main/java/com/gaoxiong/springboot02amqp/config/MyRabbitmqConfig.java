package com.gaoxiong.springboot02amqp.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * @author gaoxiong
 * @ClassName MyRabbitmqConfig
 * @Description TODO
 * @date 2018/10/15 23:35
 */
@Configuration
public class MyRabbitmqConfig {

    /**
     * 配置消息的序列化器,两种方法都可以,或者直接new出来 ,或者配置一个Bean
     * 只需要配置messageConverter 即可
     * 原因是 自动配置类中的这句代码
     * if (messageConverter != null) {
     * 				template.setMessageConverter(messageConverter);
     *                        }
     * @param
     * @return
     */
//    @Bean
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory);
////        Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter();
//        template.setMessageConverter(messageConverter());
//        return template;
//    }
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
