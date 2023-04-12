package com.wangkun.service;

import com.wangkun.domain.Dept;
import com.wangkun.service.impl.DeptService;
import com.wangkun.service.impl.EmpService;
import com.wangkun.vo.PageRequest;
import com.wangkun.vo.PageResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestEmpService {
    @Autowired
    EmpService empService;

    @Test
    public void getEmpAndDept() {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNum(1);
        pageRequest.setPageSize(5);
        PageResult allDeptByPage = empService.getAllDeptByPage(pageRequest);
        System.out.println(allDeptByPage);
    }
}
