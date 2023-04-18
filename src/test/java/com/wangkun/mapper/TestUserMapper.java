package com.wangkun.mapper;

import com.wangkun.domain.Dept;
import com.wangkun.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestUserMapper {

    @Autowired
    UserMapper UserMapper;

    @Test
    public void testGetDeptById() {
        List<User> allUser = UserMapper.getAllUser();
        System.out.println(allUser);
    }
}
