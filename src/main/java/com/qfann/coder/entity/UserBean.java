package com.qfann.coder.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by qifan on 2018/8/25.
 */

public class UserBean {
    private String userName;

    private String code;

    private int id;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCode() {
        return code;
    }

    public UserBean(String userName, String code, int id) {
        this.userName = userName;
        this.code = code;
        this.id = id;
    }

    public UserBean(){

    }

    public void setCode(String code) {
        this.code = code;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
