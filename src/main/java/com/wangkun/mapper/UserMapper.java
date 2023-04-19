package com.wangkun.mapper;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.wangkun.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface UserMapper {
    /* 查询所有user */
    List<User> getAllUser();

    /* 更新 */
    Boolean updateUser(@Param("user") User user);

    /* 新增 */
    Boolean insertUser(@Param("user") User user);

    /* 删除 */
    Boolean delByIds(@Param("ids") ArrayList<Integer> ids);
}
