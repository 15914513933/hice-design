package com.design.hice.aspectj;

import com.design.hice.annotation.OperationLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.concurrent.ExecutorService;

@Aspect
@Component
public class OperationLogAspect {
    private static volatile ExecutorService threadPool = null;

    @Pointcut("@annotation(com.design.hice.annotation.OperationLog)")
    public void log() {
    }

    @Before("log()")
    public void doBefore() {
    }

    @AfterReturning(returning = "ret", pointcut = "log()")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) {
        getLogData(joinPoint);
    }

    @AfterThrowing(throwing = "e", pointcut = "log()")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        getLogData(joinPoint);
    }

    private void getLogData(JoinPoint joinPoint) {
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            HttpServletResponse response = attributes.getResponse();
            //方法名
            String methodName = joinPoint.getSignature().getName();
            Method method = currentMethod(joinPoint, methodName);
            //类名
            String className = method.getDeclaringClass().getName();
            OperationLog operationLog = method.getAnnotation(OperationLog.class);
            //操作描述
            String operationDesc = operationLog.desc();
            //客户端类型
            String userAgent = request.getHeader(HttpHeaders.USER_AGENT);
            //请求路径
            String url = request.getRequestURI();
            //客户端ip
            String ip = null;
            //响应状态
            int responseStatus = response.getStatus();
            //请求参数
            String requestParam = "";
            Enumeration<String> enumeration = request.getParameterNames();
            while (enumeration.hasMoreElements()) {
                String name = enumeration.nextElement();
                requestParam = requestParam + name + "=" + request.getParameter(name) + "&";
            }
            stopWatch.stop();
        } catch (Exception e) {
        }
    }

    private Method currentMethod(JoinPoint joinPoint, String methodName) {
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        Method resultMethod = null;
        for (Method m : methods) {
            if (m.getName().equals(methodName)) {
                resultMethod = m;
                break;
            }
        }
        return resultMethod;
    }

}
