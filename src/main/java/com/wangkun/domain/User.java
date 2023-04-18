package com.wangkun.domain;

import lombok.Data;

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
    private String createTime;
}
