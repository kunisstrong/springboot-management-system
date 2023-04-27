package com.wangkun.controller;

import com.wangkun.domain.Dept;
import com.wangkun.service.impl.DeptService;
import com.wangkun.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 分页请求部门列表
     *
     * @param pageQuery pageNum与pageSize
     * @return Result
     */
    @PostMapping("/list")
    public ResponseVo<PageResult> list(@RequestBody PageRequest pageQuery) {
        System.out.println("");
        return ResponseVo.success(deptService.getAllDeptByPage(pageQuery));
    }

    @PostMapping("search")
    public ResponseVo<PageResult> search(@RequestBody DeptSearchParams searchParams) {
        return ResponseVo.success(deptService.search(searchParams));
    }

    @PostMapping("save")
    public ResponseVo<Boolean> saveDept(@RequestBody Dept dept) {
        return ResponseVo.success(deptService.saveDept(dept));
    }

    @PutMapping("del")
    public ResponseVo<Boolean> delDept(@RequestBody List<Integer> ids) {
        return ResponseVo.success(deptService.delDeptByIds(ids));
    }

    @PutMapping("update")
    public ResponseVo<Boolean> updateDept(@RequestBody Dept dept) {
        return ResponseVo.success(deptService.updateDept(dept));
    }

    @GetMapping("listDeptSelect")
    public ResponseVo<List<DeptSelectVo>> listDeptSelect() {
        List<DeptSelectVo> result = new ArrayList<>();
        List<Dept> allDept = deptService.getAllDept();

        for (Dept dept : allDept) {
            DeptSelectVo deptVo = new DeptSelectVo();
            deptVo.setDeptId(dept.getDeptId());
            deptVo.setDeptName(dept.getDeptName());
            result.add(deptVo);
        }
        return ResponseVo.success(result);
    }
}
