package com.wangkun.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangkun.domain.Dept;
import com.wangkun.mapper.DeptMapper;
import com.wangkun.service.IDeptService;
import com.wangkun.vo.PageRequest;
import com.wangkun.vo.PageResult;
import com.wangkun.vo.PageUtils;
import com.wangkun.vo.DeptSearchParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService implements IDeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Dept getDeptById(Integer deptId) {
        return deptMapper.getDeptById(deptId);
    }

    /**
     * 新增
     *
     * @param dept 部门
     * @return 布尔值
     */
    @Override
    public Boolean saveDept(Dept dept) {
        return deptMapper.insertDept(dept);
    }

    /**
     * 删除
     *
     * @param ids idList
     * @return 布尔值
     */
    @Override
    public Boolean delDeptByIds(List<Integer> ids) {
        return deptMapper.removeDeptByIds(ids);
    }

    /**
     * 更新
     *
     * @param dept 部门
     * @return 布尔值
     */
    @Override
    public Boolean updateDept(Dept dept) {
        return deptMapper.updateDept(dept);
    }

    /**
     * 分页查询 「deptList」
     */
    @Override
    public PageResult getAllDeptByPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getAllDeptPageInfo(pageRequest));
    }

    /**
     * 搜索
     *
     * @param searchParams
     * @return
     */
    @Override
    public PageResult search(DeptSearchParams searchParams) {
        return PageUtils.getPageResult(getSearchPageInfo(searchParams));
    }

    public List<Dept> getAllDept(){
        return deptMapper.getAllDept();
    }

    /**
     * 调用分页插件完成分页 「DeptList」
     *
     * @param pageRequest 分页参数
     * @return 部门分页
     */
    private PageInfo<Dept> getAllDeptPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Dept> sysMenus = deptMapper.getAllDeptByPage();
        return new PageInfo<>(sysMenus);
    }

    /**
     * 调用分页插件 搜索
     *
     * @param searchParams
     * @return
     */
    private PageInfo<Dept> getSearchPageInfo(DeptSearchParams searchParams) {
        int pageNum = searchParams.getPageNum();
        int pageSize = searchParams.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        Dept dept = new Dept();
        dept.setDeptName(searchParams.getDeptName());
        dept.setManager(searchParams.getManager());
        List<Dept> sysMenus = deptMapper.search(dept);
        return new PageInfo<>(sysMenus);
    }


}
