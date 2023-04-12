package com.wangkun.domain;

import com.sun.org.apache.xpath.internal.objects.XString;
import lombok.Data;

@Data
public class Emp {
    private Integer empId;
    private String empName;
    private String sex;
    private String entryDate;
    private String position;
    private Integer age;
    private Integer salary;
    private Integer deptId;
    private Dept dept;
}
