package com.qfann.coder.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by qifan on 2018/8/27.
 */
@Component
//@RabbitListener 监听 qfann 队列
@RabbitListener(queues = "qfann")
public class Consumer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @RabbitHandler 指定消息的处理方法
     * @param message
     */
    @RabbitHandler
    public void process(String message){
        logger.info("接收的消息为："+message);
    }

}
