package com.huang.messageconfirm;

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

    private static final String QUEUE_NAME = "queue_name";

    //通过 @RabbitListener 注解定义对队列的监听
    @RabbitListener(queues = QUEUE_NAME)
    public void receiveMessage(Message message, Channel channel) throws IOException {
        System.out.println("1 Received <" + new String(message.getBody()) + ">");
        //手动消息确认
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
