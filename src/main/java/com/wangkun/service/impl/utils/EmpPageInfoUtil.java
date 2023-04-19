package com.wangkun.service.impl.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.wangkun.domain.Emp;
import com.wangkun.vo.EmpAndDeptVo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class EmpPageInfoUtil {

    public static PageInfo<EmpAndDeptVo> pageInfoUtil(List<Emp> allEmp) {
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
