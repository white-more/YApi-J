package org.ifs.yapi.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YResult<T> {

    /**
     * 错误信息码
     */
    private Integer errcode;
    /**
     * 错误信息
     */
    private String errmsg;

    private T data;

    private YResult() {
    }

    private YResult(T data, Integer errcode, String errmsg) {
        this.data = data;
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public static <T> YResult<T> ok(T data) {
        return new YResult<>(data, 0, "成功！");
    }

    public static <T> YResult<T> error(Integer errcode, String errmsg) {
        return new YResult<>(null, errcode, errmsg);
    }

    public static <T> YResult<T> error() {
        return new YResult<>(null, 500, "系统错误");
    }


}
