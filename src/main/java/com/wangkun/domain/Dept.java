package com.wangkun.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Dept {
    private Integer deptId;

    private String deptName;

    private String manager;

    private Integer allNum;

    private String remark;
}
