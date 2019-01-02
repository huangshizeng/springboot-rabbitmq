package com.huang.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 黄世增
 */

@Component
public class Send {

    private static final String EXCHANGE_NAME = "exchange";
    private static final String KEY = "com.huang";
    private final AmqpTemplate rabbitTemplate;

    @Autowired
    public Send(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send() {
        String context = "hello world";
        System.out.println("Send : " + context);
        this.rabbitTemplate.convertAndSend(EXCHANGE_NAME, KEY, context);
    }
}
