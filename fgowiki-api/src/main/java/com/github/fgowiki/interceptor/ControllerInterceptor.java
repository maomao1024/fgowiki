package com.github.fgowiki.interceptor;

import com.github.fgowiki.utils.RequestUtils;
import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 拦截器：记录用户操作日志
 */
@Aspect
@Component
@Slf4j
@Order(2)
public class ControllerInterceptor {

    /**
     * 定义拦截规则：拦截com.github.fgowiki.api.controller包下面的所有类
     */
    @Pointcut("execution(* com.github.fgowiki.api.controller..*(..)) ")
    public void controllerMethodPointcut() {
    }

    /**
     * 拦截器具体实现
     *
     * @param pjp
     * @return
     */
    @Around("controllerMethodPointcut()")
    public Object Interceptor(ProceedingJoinPoint pjp) throws Throwable {

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
        Object result = null;
        HttpServletRequest request = RequestUtils.getRequest();

        log.info("请求开始，URL：{}，IP：{}", request.getRequestURL(), RequestUtils.getIpAddr());

        /*log.info("HTTP_METHOD : {} ", request.getMethod());
        log.info("HTTP_ARGS : {}", getRequestParams(request));
        log.info("METHOD : {}", methodName);
        log.info("ARGS : {}", Arrays.toString(pjp.getArgs()));*/
        long beginTime = System.currentTimeMillis();
        try {
            // 继续执行被拦截的方法
            result = pjp.proceed();
        } finally {
            long costMs = System.currentTimeMillis() - beginTime;
            log.info("请求结束，URL：{}，耗时：{}ms", request.getRequestURL(), costMs);
        }
        return result;
    }

    private String getRequestParams(HttpServletRequest request) {
        Map<String, String> map = new LinkedHashMap<>();
        request.getParameterMap().forEach((key, value) -> map.put(key, value != null && value.length == 1 ? value[0] : Arrays.toString(value)));
        return Joiner.on(",").withKeyValueSeparator("=").join(map);
    }


}