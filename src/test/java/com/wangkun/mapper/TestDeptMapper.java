package com.wangkun.mapper;

import com.wangkun.domain.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestDeptMapper {

    @Autowired
    DeptMapper deptMapper;

    @Test
    public void testGetDeptById() {
        Dept deptById = deptMapper.getDeptById(18);
        System.out.println(deptById);
    }

    @Test
    public void testSearch() {
        Dept dept = new Dept();
        dept.setDeptName("前端研");
        List<Dept> search = deptMapper.search(dept);
        System.out.println(search);
    }

    @Test
    public void testListChooseProp(){
        List<Dept> allDept = deptMapper.getAllDept();
        allDept.stream().forEach(System.out::println);
    }
}
