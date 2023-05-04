package com.wangkun.controller;

import com.wangkun.domain.User;
import com.wangkun.service.impl.UserService;
import com.wangkun.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseVo<User> login(HttpServletRequest request, @RequestBody User user) {
        // 1. 对密码进行加密
        String password = user.getPassword();
        // password = DigestUtils.md5DigestAsHex(password.getBytes());
        // 2. 查看数据库，是否有该用户、密码是否正确、状态是否为禁用
        User loginUser = userService.login(user.getUserName());
        if (loginUser == null) {
            return ResponseVo.fail("用户不存在");
        }
        if (!loginUser.getPassword().equals(password)) {
            return ResponseVo.fail("密码错误");
        }
        if (loginUser.getStatus() != 1) {
            return ResponseVo.fail("用户已被禁用");
        }
        // 3. 将用户id存入session
        request.getSession().setAttribute("loginUser", loginUser.getUserId());
        return ResponseVo.success(loginUser);
    }
}
