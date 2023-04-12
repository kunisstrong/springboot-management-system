package com.wangkun.service;

import com.wangkun.vo.PageRequest;
import com.wangkun.vo.PageResult;

public interface IEmpService {
    /**
     * 分页获取所有员工
     *
     * @return
     */
    PageResult getAllDeptByPage(PageRequest pageRequest);
}
