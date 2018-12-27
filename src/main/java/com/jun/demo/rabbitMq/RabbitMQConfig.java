package com.jun.demo.rabbitMq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@PropertySource("classpath:rabbitmqConfig.properties")
public class RabbitMQConfig {

    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }

}
