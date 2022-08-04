package com.design.hice.common;

import lombok.Data;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/20 10:06 AM
 **/
@Data
public class ResultBody<T> {
    private static int SUCCESS = 0;
    private static int FAIL = 3;
    private int code;
    private String msg;
    private T data;

    public static <T> ResultBody<T> ok() {
        return new ResultBody<T>();
    }

    public static <T> ResultBody<T> ok(T data) {
        ResultBody<T> resultBody = new ResultBody<>();
        resultBody.setCode(SUCCESS);
        resultBody.setData(data);
        return resultBody;
    }

    public static <T> ResultBody<T> fail(String msg) {
        ResultBody<T> resultBody = new ResultBody<>();
        resultBody.setCode(FAIL);
        resultBody.setMsg(msg);
        return resultBody;
    }

    public static <T> ResultBody<T> fail(int code, String msg) {
        ResultBody<T> resultBody = new ResultBody<>();
        resultBody.setCode(code);
        resultBody.setMsg(msg);
        return resultBody;
    }
}
