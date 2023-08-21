package com.wangkun.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Emp {
    public Integer empId;
    public String empName;
    public String sex;
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date entryDate;
    public String position;
    public Integer age;
    public Integer salary;
    public Integer deptId;
    public Dept dept;
}
