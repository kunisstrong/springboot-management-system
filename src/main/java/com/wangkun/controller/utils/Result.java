package com.wangkun.controller.utils;

import lombok.Data;

@Data
public class Result {

    private Boolean flag;

    private Object data;

    public Result(Boolean flag) {
        this.flag = flag;
    }

    public Result(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}
