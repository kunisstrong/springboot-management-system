package com.wangkun.controller;

import com.wangkun.service.impl.EmpService;
import com.wangkun.vo.PageRequest;
import com.wangkun.vo.PageResult;
import com.wangkun.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("emp")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 分页查询所有员工
     */
    @PostMapping("list")
    public ResponseVo<PageResult> getAllEmpByPage(@RequestBody PageRequest pageRequest) {

        return ResponseVo.success(empService.getAllDeptByPage(pageRequest));

    }
}
