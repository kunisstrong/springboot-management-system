package com.wangkun.vo;

import com.wangkun.domain.Dept;
import com.wangkun.domain.Emp;
import lombok.Data;

import java.util.Date;

@Data
public class EmpAndDeptVo {
    private String deptName;
    private Integer empId;
    private String empName;
    private String sex;
    private Date entryDate;
    private String position;
    private Integer age;
    private Integer salary;
    private Integer deptId;
}
