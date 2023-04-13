package com.wangkun.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangkun.domain.Emp;
import com.wangkun.mapper.EmpMapper;
import com.wangkun.service.IEmpService;
import com.wangkun.vo.*;
import org.springframework.beans.BeanUtils;
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


    @Override
    public Boolean delEmpByIds(List<Integer> ids) {
        return empMapper.delEmpByIds(ids);
    }

    @Override
    public Boolean saveEmp(Emp emp) {
        return empMapper.insertEmp(emp);
    }

    @Override
    public PageResult search(EmpSearchParams empSearchParams) {
        return PageUtils.getPageResult(searchByPage(empSearchParams));
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

    private PageInfo<EmpAndDeptVo> searchByPage(EmpSearchParams empSearchParams) {
        int pageNum = empSearchParams.getPageNum();
        int pageSize = empSearchParams.getPageSize();
        PageHelper.startPage(pageNum, pageSize);

        Emp emp = new Emp();
        emp.setEmpName(empSearchParams.getEmpName());
        emp.setPosition(empSearchParams.getPosition());
        emp.setDeptId(empSearchParams.getDeptId());
        List<Emp> searchEmp = empMapper.search(emp);

        List<EmpAndDeptVo> empAndDeptVoList = new ArrayList<>();

        for (Emp searchEmpItem : searchEmp) {
            EmpAndDeptVo empAndDeptVo = new EmpAndDeptVo();
            BeanUtils.copyProperties(searchEmpItem, empAndDeptVo);
            empAndDeptVo.setDeptName(searchEmpItem.getDept().getDeptName());
            empAndDeptVoList.add(empAndDeptVo);
        }
        PageInfo<EmpAndDeptVo> empAndDeptVoListPageInfo = new PageInfo<>(empAndDeptVoList);
        if (searchEmp instanceof Page) {
            Page<Emp> page = (Page<Emp>) searchEmp;
            empAndDeptVoListPageInfo.setTotal(page.getTotal());
            empAndDeptVoListPageInfo.setPageNum(page.getPageNum());
            empAndDeptVoListPageInfo.setPageSize(page.getPageSize());
            empAndDeptVoListPageInfo.setPages(page.getPages());
        }

        return empAndDeptVoListPageInfo;
    }

    /**
     * 调用分页插件 所有员工
     *
     * @param pageRequest
     * @return
     */
    private PageInfo<EmpAndDeptVo> getAllEmp(PageRequest pageRequest) {
        int pageSize = pageRequest.getPageSize();
        int pageNum = pageRequest.getPageNum();
        PageHelper.startPage(pageNum, pageSize);
        // allEmp有我们要的所有信息，包括分页的数据
        List<Emp> allEmp = empMapper.getAllEmp();

        List<EmpAndDeptVo> empAndDeptVoList = new ArrayList<>();

        for (Emp emp : allEmp) {
            EmpAndDeptVo empAndDeptVo = new EmpAndDeptVo();
            BeanUtils.copyProperties(emp, empAndDeptVo);
            empAndDeptVo.setDeptName(emp.getDept().getDeptName());
            empAndDeptVoList.add(empAndDeptVo);
        }

        PageInfo<EmpAndDeptVo> empAndDeptVoListPageInfo = new PageInfo<>(empAndDeptVoList);
        if (allEmp instanceof Page) {
            Page<Emp> page = (Page<Emp>) allEmp;
            empAndDeptVoListPageInfo.setTotal(page.getTotal());
            empAndDeptVoListPageInfo.setPageNum(page.getPageNum());
            empAndDeptVoListPageInfo.setPageSize(page.getPageSize());
            empAndDeptVoListPageInfo.setPages(page.getPages());
        }
        return empAndDeptVoListPageInfo;
    }


}


