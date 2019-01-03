package com.huang.helloworld;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 黄世增
 */

@Component
public class Send {

    private static final String QUEUE_NAME = "queue_name1";
    private final AmqpTemplate rabbitTemplate;

    @Autowired
    public Send(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send() {
        for (int i = 0; i < 5; i++) {
            String context = "hello world " + i;
            System.out.println("Send : " + context);
            this.rabbitTemplate.convertAndSend(QUEUE_NAME, context);
        }
    }
}
