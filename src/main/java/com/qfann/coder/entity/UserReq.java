package com.qfann.coder.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Created by qifan on 2018/8/26.
 */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class UserReq {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @ApiModelProperty(value = "id",dataType = "int",name = "id",example = "1")
    int id;

    @ApiModelProperty(value = "code",dataType = "String",name = "code",example = "001")
    @NotBlank(message = "编码不能为空")
    String code;

    @ApiModelProperty(value = "userName",dataType = "String",name = "userName",example = "qf")
    @NotBlank(message = "名字不能为空")
    String userName;
}
