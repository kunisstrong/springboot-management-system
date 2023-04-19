package com.wangkun.mapper;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.wangkun.domain.Dept;
import com.wangkun.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
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
    @Test
    public void update() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("李四");
        user.setSex("");
        user.setAge(12);
        user.setAddress("四川南充");
        user.setEmail("910009136@qq.com");
        user.setCreateTime(new Date());
        user.setStatus(1);
        user.setIdentityCard("23817892489172123");
        Boolean aBoolean = UserMapper.updateUser(user);
        System.out.println(aBoolean);
    }
    @Test
    public void save() {
        User user = new User();
        user.setUserName("张三");
        user.setSex("男");
        user.setAge(12);
        user.setAddress("黑龙江省哈尔滨市");
        user.setEmail("9100091322@qq.com");
        user.setCreateTime(new Date());
        user.setStatus(1);
        user.setIdentityCard("123712678368123861");
        Boolean aBoolean = UserMapper.insertUser(user);
        System.out.println(aBoolean);

    }

    @Test
    public void delUserByIds() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(3);
        Boolean aBoolean = UserMapper.delByIds(integers);
        System.out.println(aBoolean);
    }
}
