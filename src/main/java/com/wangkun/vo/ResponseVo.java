package com.wangkun.vo;

import com.wangkun.constant.SystemConstant;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseVo<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> ResponseVo<T> success(T data) {
        return new ResponseVo<T>().setCode(SystemConstant.CODE_SUCCESS).setMsg("成功").setData(data);
    }

    public static <T> ResponseVo<T> fail(String msg) {
        return new ResponseVo<T>().setCode(SystemConstant.CODE_FAIL).setMsg(msg);
    }

    public static <T> ResponseVo<T> fail(int code, String msg) {
        return new ResponseVo<T>().setCode(code).setMsg(msg);
    }
}
