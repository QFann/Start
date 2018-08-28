package com.qfann.coder.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * Created by qifan on 2018/8/27.
 */
public class RabbitConfig {


    @Bean
    public Queue qfannQueue(){
        return new Queue("qfann");
    }

}
