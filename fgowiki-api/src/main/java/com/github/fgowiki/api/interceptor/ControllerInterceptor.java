package com.github.fgowiki.api.interceptor;

import com.google.common.base.Joiner;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 拦截器：记录用户操作日志
 */
@Aspect
@Component
public class ControllerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(ControllerInterceptor.class);

    /**
     * 定义拦截规则：拦截com.github.fgowiki.api.controller包下面的所有类中，有@RequestMapping注解的方法。
     */
    @Pointcut("execution(* com.github.fgowiki.api.controller..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerMethodPointcut() {
    }

    /**
     * 拦截器具体实现
     *
     * @param pjp
     * @return
     */
    @Around("controllerMethodPointcut()")
    public Object Interceptor(ProceedingJoinPoint pjp) {

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
        Object result = null;
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("请求开始，URL：{}，IP：{}", request.getRequestURL(), request.getRemoteAddr());

        logger.info("HTTP_METHOD : {} ", request.getMethod());
        logger.info("HTTP_ARGS : {}", getRequestParams(request));
        logger.info("METHOD : {}", methodName);
        logger.info("ARGS : {}", Arrays.toString(pjp.getArgs()));
        long beginTime = System.currentTimeMillis();
        try {
            // 继续执行被拦截的方法
            result = pjp.proceed();
        } catch (Throwable e) {
            logger.info("exception: ", e);
        }

        long costMs = System.currentTimeMillis() - beginTime;
        logger.info("请求结束，URL：{}，耗时：{}ms", request.getRequestURL(), costMs);
        return result;
    }

    private String getRequestParams(HttpServletRequest request) {
        Map<String, String> map = new LinkedHashMap<>();
        request.getParameterMap().forEach((key, value) -> map.put(key, value != null && value.length == 1 ? value[0] : Arrays.toString(value)));
        return Joiner.on(",").withKeyValueSeparator("=").join(map);
    }

}