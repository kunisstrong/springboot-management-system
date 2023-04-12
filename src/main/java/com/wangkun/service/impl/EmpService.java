package com.wangkun.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangkun.domain.Emp;
import com.wangkun.mapper.EmpMapper;
import com.wangkun.service.IEmpService;
import com.wangkun.vo.EmpAndDeptVo;
import com.wangkun.vo.PageRequest;
import com.wangkun.vo.PageResult;
import com.wangkun.vo.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpService implements IEmpService {
    @Autowired
    private EmpMapper empMapper;

    /**
     * 更新
     */
    @Override
    public Boolean updateEmp(Emp emp) {
        return empMapper.updateEmp(emp);
    }

    /**
     * 分页查询所有员工
     *
     * @param pageRequest
     * @return
     */
    @Override
    public PageResult getAllDeptByPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getAllEmp(pageRequest));
    }


    /**
     * 调用分页插件 所有员工
     *
     * @param pageRequest
     * @return
     */
    private PageInfo<Emp> getAllEmp(PageRequest pageRequest) {
        int pageSize = pageRequest.getPageSize();
        int pageNum = pageRequest.getPageNum();
        PageHelper.startPage(pageNum, pageSize);

        List<Emp> allEmp = empMapper.getAllEmp();

        return new PageInfo<>(allEmp);
    }
}
