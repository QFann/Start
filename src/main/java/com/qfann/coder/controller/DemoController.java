package com.qfann.coder.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qifan on 2018/8/27.
 */
@RestController
public class DemoController {

    //AmqpTemplate接口定义了发送和接收消息的基本操作,目前spring官方也只集成了Rabbitmq一个消息队列。。
    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("/send")
    public String send(String msg) {
        //发送消息
        amqpTemplate.convertAndSend("qfann", msg);
        return "消息：" + msg + ",已发送";
    }

    @GetMapping("/mock")
    public String demo(String msg) {
        return msg;
    }

}
