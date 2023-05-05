package com.wangkun.controller;

import com.wangkun.domain.User;
import com.wangkun.service.impl.UserService;
import com.wangkun.vo.PageResult;
import com.wangkun.vo.ResponseVo;
import com.wangkun.vo.UserSearchParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("logout")
    public ResponseVo<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("loginUser");
        return ResponseVo.success("退出成功");
    }

    /**
     * 登录
     *
     * @param request 存session用的
     * @param user 登录的用户名与密码
     * @return 成功返回用户信息
     */
    @PostMapping("login")
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

    @PostMapping("list")
    public ResponseVo<PageResult> search(@RequestBody UserSearchParams userSearchParams) {
        PageResult search = userService.search(userSearchParams);
        return ResponseVo.success(search);
    }

    @PostMapping("save")
    public ResponseVo<Boolean> saveUser(@RequestBody User user) {
        Boolean save = userService.save(user);
        return ResponseVo.success(save);
    }

    @PutMapping("update")
    public ResponseVo<Boolean> updateUser(@RequestBody User user) {
        Boolean aBoolean = userService.updateUser(user);
        return ResponseVo.success(aBoolean);
    }

    @PutMapping("del")
    public ResponseVo<Boolean> delByIds(@RequestBody ArrayList<Integer> ids) {
        Boolean aBoolean = userService.delByIds(ids);
        return ResponseVo.success(aBoolean);
    }
}
