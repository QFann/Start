package com.qfann.coder.service;

import com.qfann.coder.entity.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by qifan on 2018/8/26.
 */
@Service
public class IUserService {

    public void insert(UserBean userBean){
        System.out.println(userBean.getCode());
        System.out.println(userBean.getId());
        System.out.println(userBean.getUserName());
    }

}
