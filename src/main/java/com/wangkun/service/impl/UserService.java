package com.wangkun.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangkun.domain.User;
import com.wangkun.mapper.UserMapper;
import com.wangkun.service.IUserService;
import com.wangkun.vo.PageRequest;
import com.wangkun.vo.PageResult;
import com.wangkun.vo.PageUtils;
import com.wangkun.vo.UserSearchParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public Boolean save(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public Boolean delByIds(ArrayList<Integer> ids) {
        return userMapper.delByIds(ids);
    }

    @Override
    public Boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public PageResult search(UserSearchParams userSearchParams) {

        return PageUtils.getPageResult(userPageInfo(userSearchParams));
    }

    private PageInfo<User> userPageInfo(UserSearchParams userSearchParams) {
        int pageNum = userSearchParams.getPageNum();
        int pageSize = userSearchParams.getPageSize();
        PageHelper.startPage(pageNum, pageSize);

        User user = new User();
        user.setUserName(userSearchParams.getUserName());
        user.setAddress(userSearchParams.getAddress());
        List<User> allUser = userMapper.getAllUser(user);

        return new PageInfo<>(allUser);
    }
}
