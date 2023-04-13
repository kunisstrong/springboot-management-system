package com.wangkun.mapper;

import com.wangkun.domain.Emp;
import com.wangkun.vo.EmpAndDeptVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    /* 获取所有员工 */
    List<Emp> getAllEmp();

    /* 更新 */
    Boolean updateEmp(@Param("emp") Emp emp);

    /* 删除 */
    Boolean delEmpByIds(@Param("ids") List<Integer> ids);

    Boolean insertEmp(@Param("emp") Emp emp);

    List<Emp> search(@Param("emp") Emp emp);
}
