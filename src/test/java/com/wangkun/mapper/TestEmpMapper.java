package com.wangkun.mapper;

import com.wangkun.domain.Dept;
import com.wangkun.domain.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestEmpMapper {

    @Autowired
    EmpMapper empMapper;

    @Test
    public void testGetAllEmp() {
        for (Emp emp : empMapper.getAllEmp()) {
            System.out.println(emp);
        }

    }
}
