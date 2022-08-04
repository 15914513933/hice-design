package com.design.hice.exception;

import lombok.Data;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/28 11:33 AM
 **/
@Data
public class BusinessException extends RuntimeException {
    private int code;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, int code) {
        super(message);
        this.code = code;
    }
}
