package com.wangkun.vo;

import lombok.Data;

@Data
public class EmpSearchParams extends PageRequest {
    private Integer deptId;
    private String EmpName;
    private String position;
}
