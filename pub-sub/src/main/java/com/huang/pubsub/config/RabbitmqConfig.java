package com.huang.pubsub.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
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

    @Bean
    public Queue queue1() {
        return new Queue(QUEUE_NAME1);
    }

    @Bean
    public Queue queue2() {
        return new Queue(QUEUE_NAME2);
    }

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding banding1(Queue queue1, FanoutExchange exchange) {
        return BindingBuilder.bind(queue1).to(exchange);
    }

    @Bean
    public Binding banding2(Queue queue2, FanoutExchange exchange) {
        return BindingBuilder.bind(queue2).to(exchange);
    }
}
