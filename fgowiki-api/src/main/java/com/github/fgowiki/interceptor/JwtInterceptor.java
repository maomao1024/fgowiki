package com.github.fgowiki.interceptor;

import com.github.fgowiki.exception.UnloginException;
import com.github.fgowiki.utils.RequestUtils;
import com.github.fgowiki.utils.TokenUtils;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * jwt拦截器
 *
 * @author jiang
 * @create 2018-03-29 19:21
 **/
@Aspect
@Component
@Slf4j
public class JwtInterceptor {

    private static final String AUTHORIZATION = "Authorization";
    private static final String BEARER = "Bearer";

    /**
     * 定义拦截规则：拦截com.github.fgowiki.api.controller包下面的所有类
     */
    @Pointcut("execution(* com.github.fgowiki.api.controller..*(..)) ")
    public void controllerMethodPointcut() {

    }

    @Around("controllerMethodPointcut()")
    public Object Interceptor(ProceedingJoinPoint pjp) throws Throwable {
        HttpServletRequest request = RequestUtils.getRequest();
        if(!"login".equals(request.getRequestURI().replaceAll("[/]+",""))){
            String auth = RequestUtils.getRequest().getHeader(AUTHORIZATION);
            if (!Strings.isNullOrEmpty(auth) && auth.startsWith(BEARER)) {
                auth = auth.substring(BEARER.length() + 1);
            }else {
                throw new UnloginException("请登录后再试");
            }
            TokenUtils.parse(auth);
        }
        return pjp.proceed();
    }
}
