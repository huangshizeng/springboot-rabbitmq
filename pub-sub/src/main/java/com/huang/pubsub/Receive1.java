package com.huang.pubsub;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 黄世增
 */

@Component
public class Receive1 {

    private static final String QUEUE_NAME = "queue_name1";

    //通过 @RabbitListener 注解定义对队列的监听
    @RabbitListener(queues = QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("1 Received <" + message + ">");
    }
}
