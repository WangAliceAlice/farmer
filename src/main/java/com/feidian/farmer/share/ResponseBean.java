package com.feidian.farmer.share;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseBean {

    // 状态
    private Integer status;
    // 信息
    private String msg;
    // 返回的数据
    private Object obj;

    private ResponseBean() {

    }

    public static ResponseBean build() {
        return new ResponseBean();
    }

    public static ResponseBean ok() {
        return new ResponseBean(200, null, null);
    }

    public static ResponseBean ok(String msg, Object obj) {
        return new ResponseBean(200, msg, obj);
    }

    public static ResponseBean ok(String msg) {
        return new ResponseBean(200, msg, null);
    }

    public static ResponseBean error(String msg, Object obj) {
        return new ResponseBean(500, msg, obj);
    }

    public static ResponseBean error(String msg) {
        return new ResponseBean(500, msg, null);
    }

    private ResponseBean(Integer status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

}
