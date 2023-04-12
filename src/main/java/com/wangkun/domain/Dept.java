package com.wangkun.domain;

import lombok.Data;

@Data
public class Dept {
    private Integer deptId;

    private String deptName;


    private String manager;

    private Integer allNum;

    private String remark;
}
