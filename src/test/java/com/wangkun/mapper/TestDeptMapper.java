package com.wangkun.mapper;

import com.wangkun.domain.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestDeptMapper {

    @Autowired
    DeptMapper deptMapper;

    @Test
    public void testGetDeptById() {
        Dept deptById = deptMapper.getDeptById(18);
        System.out.println(deptById);
    }
}
