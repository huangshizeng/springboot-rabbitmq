package com.huang.helloworld.config;

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

    private static final String QUEUE_NAME = "queue_name1";
    private static final String QUEUE_NAME2 = "queue_name2";

    @Bean
    public Queue Queue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public Queue Queue2() {
        return new Queue(QUEUE_NAME2);
    }
}
