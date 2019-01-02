package com.huang.topic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 在 Spring Boot 中使用 @Bean 注册一个队列
 *
 * @author 黄世增
 */

@Configuration
public class RabbitmqConfig {

    private static final String QUEUE_NAME1 = "queue_name1";
    private static final String QUEUE_NAME2 = "queue_name2";
    private static final String EXCHANGE_NAME = "exchange";
    private static final String KEY1 = "com.*";
    private static final String KEY2 = "*.huang";

    @Bean
    public Queue queue1() {
        return new Queue(QUEUE_NAME1);
    }

    @Bean
    public Queue queue2() {
        return new Queue(QUEUE_NAME2);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding banding1(Queue queue1, TopicExchange exchange) {
        return BindingBuilder.bind(queue1).to(exchange).with(KEY1);
    }

    @Bean
    public Binding banding2(Queue queue2, TopicExchange exchange) {
        return BindingBuilder.bind(queue2).to(exchange).with(KEY2);
    }
}
