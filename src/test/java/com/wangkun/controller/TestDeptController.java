package com.wangkun.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.ArrayList;

@SpringBootTest
public class TestDeptController {
    @Autowired
    private DeptController deptController;

    @Test
    public void testSearch() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        String s = strings.get(0);
        System.out.println("s-----   " + s);
    }

    @Test
    public void testListDeptSelect() {
        class Test<T> {
        }
    }
}
