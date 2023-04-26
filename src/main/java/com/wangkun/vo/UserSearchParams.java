package com.wangkun.vo;

import lombok.Data;

@Data
public class UserSearchParams extends PageRequest{
    private String userName;
    private String address;
}
