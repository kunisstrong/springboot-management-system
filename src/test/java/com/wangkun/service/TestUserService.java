package com.wangkun.service;

import com.wangkun.domain.User;
import com.wangkun.service.impl.EmpService;
import com.wangkun.service.impl.UserService;
import com.wangkun.vo.PageRequest;
import com.wangkun.vo.PageResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class TestUserService {
    @Autowired
    UserService userService;

    @Test
    public void getAllUser() {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNum(1);
        pageRequest.setPageSize(5);
        PageResult search = userService.search(pageRequest);
        System.out.println(search);
    }

    @Test
    public void save() {
        User user = new User();
        user.setUserName("王五");
        user.setSex("男");
        user.setAge(12);
        user.setAddress("黑龙江省大庆市");
        user.setEmail("9100091322@qq.com");
        user.setCreateTime(new Date());
        user.setStatus(1);
        user.setIdentityCard("123712678368123861");
        Boolean aBoolean = userService.save(user);
        System.out.println(aBoolean);
    }
}
