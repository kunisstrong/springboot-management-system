package com.wangkun.mapper;

import com.wangkun.domain.Emp;
import com.wangkun.vo.EmpAndDeptVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    /* 获取所有员工 */
    List<Emp> getAllEmp();
}
