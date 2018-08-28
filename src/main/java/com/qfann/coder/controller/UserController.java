package com.qfann.coder.controller;

import com.qfann.coder.entity.UserBean;
import com.qfann.coder.entity.UserReq;
import com.qfann.coder.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by qifan on 2018/8/26.
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户Api")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/add")
    @ApiOperation(value = "用户新增")
    public HashMap userInfo( UserReq userReq){

        UserBean userBean = new UserBean();
        userBean.setCode(userReq.getCode());
        userBean.setId(userReq.getId());
        userBean.setUserName(userReq.getUserName());
        userService.insert(userBean);
        HashMap result = new HashMap();
        result.put("retCode","01");
        result.put("retMsg","成功");
        return result;

    }


}
