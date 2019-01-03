package com.huang.deadletterexchange.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 生产者 --> 消息 --> 交换机 --> 死信队列 --> 变成死信 --> DLX交换机 --> 队列 --> 消费者
 *
 * @author 黄世增
 */

@Configuration
public class RabbitmqConfig {

    private static final String DEAD_QUEUE_NAME1 = "dead-queue";
    private static final String QUEUE_NAME = "queue_name";
    private static final String EXCHANGE_NAME = "exchange";
    private static final String DEAD_LETTER_EXCHANGE_NAME = "dead";

    /**
     * 真实的消费队列
     *
     * @return 真实的消费队列
     */
    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME);
    }

    /**
     * 死信队列
     *
     * @return 死信队列
     */
    @Bean
    public Queue deadLetterQueue() {
        return QueueBuilder.durable(DEAD_QUEUE_NAME1)
                .withArgument("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE_NAME) //设置过期消息在转发的死信交换机
                .withArgument("x-dead-letter-routing-key", "dead-key") //设置过期消息在转发时携带的routing-key名称
                .withArgument("x-message-ttl", 10000) // 设置队列的过期时间
                .build();
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    /**
     * 死信交换机
     *
     * @return 死信交换机
     */
    @Bean
    public DirectExchange deadExchange() {
        return new DirectExchange(DEAD_LETTER_EXCHANGE_NAME);
    }

    @Bean
    public Binding banding1(Queue deadLetterQueue, DirectExchange exchange) {
        return BindingBuilder.bind(deadLetterQueue).to(exchange).with("key");
    }

    @Bean
    public Binding banding2(Queue queue, DirectExchange deadExchange) {
        return BindingBuilder.bind(queue).to(deadExchange).with("dead-key");
    }
}
