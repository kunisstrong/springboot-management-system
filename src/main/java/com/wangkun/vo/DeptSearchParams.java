package com.wangkun.vo;

import lombok.Data;

@Data
public class DeptSearchParams extends PageRequest {
    private Integer deptId;

    private String deptName;

    private String manager;

    private Integer allNum;

    private String remark;
}
