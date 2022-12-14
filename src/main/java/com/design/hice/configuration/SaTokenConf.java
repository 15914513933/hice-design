package com.design.hice.configuration;

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import com.design.hice.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/1 12:56 PM
 **/
@Configuration
public class SaTokenConf implements WebMvcConfigurer {

    // 注册Sa-Token的注解拦截器，打开注解式鉴权功能
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册注解拦截器，并排除不需要注解鉴权的接口地址 (与登录拦截器无关)
        registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns("/**");
    }
}
