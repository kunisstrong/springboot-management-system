package com.wangkun.controller;

import com.wangkun.domain.Emp;
import com.wangkun.service.impl.EmpService;
import com.wangkun.vo.EmpSearchParams;
import com.wangkun.vo.PageRequest;
import com.wangkun.vo.PageResult;
import com.wangkun.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 搜索
     *
     * @param empSearchParams
     * @return
     */
    @PostMapping("search")
    public ResponseVo<PageResult> search(@RequestBody EmpSearchParams empSearchParams) {
        return ResponseVo.success(empService.search(empSearchParams));
    }

    /**
     * 更新
     *
     * @param emp
     * @return
     */
    @PutMapping("update")
    public ResponseVo<Boolean> updateEmp(@RequestBody Emp emp) {
        return ResponseVo.success(empService.updateEmp(emp));
    }


    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @PutMapping("del")
    public ResponseVo<Boolean> delEmpByIds(@RequestBody List<Integer> ids) {
        return ResponseVo.success(empService.delEmpByIds(ids));
    }

    @PostMapping("save")
    public ResponseVo<Boolean> saveEmp(@RequestBody Emp emp) {
        return ResponseVo.success(empService.saveEmp(emp));
    }

}
