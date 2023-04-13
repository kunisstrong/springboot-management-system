package com.wangkun.service;

import com.wangkun.domain.Emp;
import com.wangkun.vo.EmpSearchParams;
import com.wangkun.vo.PageRequest;
import com.wangkun.vo.PageResult;

import java.util.List;

public interface IEmpService {
    /*分页获取所有员工*/
    PageResult getAllDeptByPage(PageRequest pageRequest);

    /*更新*/
    Boolean updateEmp(Emp emp);

    /* 删除 */
    Boolean delEmpByIds(List<Integer> ids);

    /* 新增 */
    Boolean saveEmp(Emp emp);

    /* 搜索 */
    PageResult search(EmpSearchParams empSearchParams);
}
