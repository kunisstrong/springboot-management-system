package com.wangkun.service;

import com.wangkun.domain.User;
import com.wangkun.vo.PageRequest;
import com.wangkun.vo.PageResult;
import com.wangkun.vo.UserSearchParams;
import net.sf.jsqlparser.statement.create.table.Index;

import java.util.ArrayList;

public interface IUserService {
    /* 新增 */
    Boolean save(User user);

    /* 删除 */
    Boolean delByIds(ArrayList<Integer> ids);

    /* 更新 */
    Boolean updateUser(User user);

    /* 查询 */
    PageResult search(UserSearchParams userSearchParams);
}
