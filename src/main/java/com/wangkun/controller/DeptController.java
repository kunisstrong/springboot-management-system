package com.wangkun.controller;

import com.wangkun.controller.utils.Result;
import com.wangkun.domain.Dept;
import com.wangkun.service.impl.DeptService;
import com.wangkun.vo.PageRequest;
import com.wangkun.vo.PageResult;
import com.wangkun.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return ResponseVo.success(deptService.getAllDeptByPage(pageQuery));
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

//    @PostMapping("search")
//    public Result search() {
//
//    }
}
