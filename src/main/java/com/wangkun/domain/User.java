package com.wangkun.domain;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer userId;
    private String userName;
    private String sex;
    private Integer age;
    private String identityCard;
    private String email;
    private String address;
    private Integer status;
    private Date createTime;
}
