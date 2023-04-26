package com.wangkun.controller;

import com.wangkun.domain.User;
import com.wangkun.service.impl.UserService;
import com.wangkun.vo.PageResult;
import com.wangkun.vo.ResponseVo;
import com.wangkun.vo.UserSearchParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

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
