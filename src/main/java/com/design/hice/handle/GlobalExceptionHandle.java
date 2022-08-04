package com.design.hice.handle;

import com.design.hice.common.ResultBody;
import com.design.hice.exception.BusinessException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/28 11:50 AM
 **/
@Component
@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(BusinessException.class)
    public ResultBody<Object> businessExceptionHandle(BusinessException e){
        e.printStackTrace();
        return ResultBody.fail("系统异常");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResultBody<Object> runtimeExceptionHandle(RuntimeException e){
        e.printStackTrace();
        return ResultBody.fail("系统异常");
    }
}
