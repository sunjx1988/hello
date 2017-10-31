package com.jxsun.mvc;

import com.sun.net.httpserver.Authenticator;

public class RestResult<T> {

    public static final String SUCCESS = "success";

    public static final String FAIL = "fail";

    private int code;

    private String msg;

    private T data;

    public RestResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
