package com.wangkun.service;

import com.wangkun.domain.User;
import com.wangkun.vo.PageRequest;
import com.wangkun.vo.PageResult;
import com.wangkun.vo.UserSearchParams;

import java.util.ArrayList;
import java.util.List;

public interface IUserService {
    /* 登录 */
    User login(String userName);

    /* 新增 */
    Boolean save(User user);

    /* 删除 */
    Boolean delByIds(ArrayList<Integer> ids);

    /* 更新 */
    Boolean updateUser(User user);

    /* 查询 */
    PageResult search(UserSearchParams userSearchParams);
}
