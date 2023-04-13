package com.wangkun.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Emp {
    public Integer empId;
    public String empName;
    public String sex;
    public Date entryDate;
    public String position;
    public Integer age;
    public Integer salary;
    public Integer deptId;
    public Dept dept;
}
