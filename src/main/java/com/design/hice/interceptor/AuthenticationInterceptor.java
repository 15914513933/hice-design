package com.design.hice.interceptor;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.design.hice.annotation.NoLogin;
import com.design.hice.common.ResultBody;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/27 5:59 PM
 **/
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        try {
            if (handler instanceof HandlerMethod == false) {
                return true;
            }
            Method method = ((HandlerMethod) handler).getMethod();

            NoLogin noLogin = method.getAnnotation(NoLogin.class);
            if (noLogin != null) {
                return true;
            }
            StpUtil.checkLogin();
        } catch (Exception e) {
            writeJson(response, JSON.toJSONString(ResultBody.fail(401, "token失效")), MediaType.APPLICATION_JSON_VALUE);
            return false;
        }
        // 通过验证
        return true;
    }

    public static void writeJson(HttpServletResponse response, String string, String type) {
        try {
            response.setContentType(type);
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
