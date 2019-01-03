package com.huang.helloworld;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author 黄世增
 */

@Component
public class Receive {

    private static final String QUEUE_NAME = "queue_name1";
    private static final String QUEUE_NAME2 = "queue_name2";

    //通过 @RabbitListener 注解定义对队列的监听
    @RabbitListener(queues = QUEUE_NAME)
    public void receiveMessage(Message message, Channel channel) throws InterruptedException, IOException {
        Thread.sleep(2000);
        System.out.println("Received <" + new String(message.getBody()) + ">");
        //手动消息确认
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

    @RabbitListener(queues = QUEUE_NAME2)
    public void receiveMessage(User user) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Received <" + user + ">");
    }
}
