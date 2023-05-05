package com.wangkun.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String sex;
    private Integer age;
    private String idCard;
    private String email;
    private String address;
    private Integer status;
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
}
