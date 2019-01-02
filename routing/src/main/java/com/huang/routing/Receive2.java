package com.huang.routing;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 黄世增
 */

@Component
public class Receive2 {

    private static final String QUEUE_NAME = "queue_name2";

    //通过 @RabbitListener 注解定义对队列的监听
    @RabbitListener(queues = QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("2 Received <" + message + ">");
    }
}
