package com.wangkun.controller;

import com.wangkun.service.impl.UserService;
import com.wangkun.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("logout")
public class logoutController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseVo<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("loginUser");
        return ResponseVo.success("退出成功");
    }
}
