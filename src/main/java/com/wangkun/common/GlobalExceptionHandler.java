package com.wangkun.common;

import com.wangkun.vo.ResponseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
public class GlobalExceptionHandler {
    /**
     * 异常处理方法
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseVo<String> exceptionHandler(SQLIntegrityConstraintViolationException ex) {
        return ResponseVo.fail("失败了");
    }
}
