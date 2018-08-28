package com.qfann.coder.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qifan on 2018/8/26.
 */
@RestController
@RequestMapping("/redis")
@Api(tags = "redis测试Api")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("set/{key}/{value}")
    @ApiOperation(value = "设置缓存")
    public String set(@PathVariable("key")String key,@PathVariable("value")String value){
        redisTemplate.opsForValue().set(key,value);
        return key+","+value;
    }


    @RequestMapping("get/{key}")
    @ApiOperation(value = "根据key获取缓存")
    public String get(@PathVariable("key")String key){
        return "key="+key+",value="+redisTemplate.opsForValue().get(key);

    }

}
