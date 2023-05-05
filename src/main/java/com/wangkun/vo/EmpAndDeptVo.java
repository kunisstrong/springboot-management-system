package com.wangkun.vo;

import com.wangkun.domain.Emp;
import lombok.Data;

@Data
public class EmpAndDeptVo extends Emp {
    private String deptName;
    private Integer deptId;
}
