package com.wangkun.service;

import com.wangkun.domain.Dept;
import com.wangkun.service.impl.DeptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestDeptService {
    @Autowired
    private DeptService deptService;

    @Test
    public void testGetDeptById() {
        Dept deptById = deptService.getDeptById(17);
        System.out.println(deptById);
    }
}
