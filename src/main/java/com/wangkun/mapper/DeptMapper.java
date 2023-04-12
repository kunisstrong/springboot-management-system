package com.wangkun.mapper;


import com.wangkun.domain.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeptMapper {
    Dept getDeptById(@Param("deptId") Integer deptId);

    /**
     * 分页查询所有dept
     */
    List<Dept> getAllDeptByPage();

    /* 新增 */
    Boolean insertDept(@Param("dept") Dept dept);

    /**
     * 删除
     *
     * @param ids id集合
     * @return 布尔值
     */
    Boolean removeDeptByIds(@Param("ids") List<Integer> ids);

    /**
     * 修改
     *
     * @param dept 部门
     * @return 布尔值
     */
    Boolean updateDept(@Param("dept") Dept dept);

    /**
     * 搜索
     *
     * @return 「deptList」
     */
    List<Dept> search(@Param("dept") Dept dept);

    /* 获取所有部门 */
    List<Dept> getAllDept();
}

