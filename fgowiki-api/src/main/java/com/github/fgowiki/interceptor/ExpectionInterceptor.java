package com.github.fgowiki.interceptor;

import com.github.fgowiki.core.bean.ResultBean;
import com.github.fgowiki.exception.CheckedException;
import com.github.fgowiki.exception.UnloginException;
import com.github.fgowiki.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * @author jiang
 * @create 2018-03-26 19:07
 **/
@Aspect
@Component
@Slf4j
@Order(1)
public class ExpectionInterceptor {
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
    public Object Interceptor(ProceedingJoinPoint pjp) {
        Object result;
        try {
            result = pjp.proceed();
            //result = handlerResponse(pjp.proceed());
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }
        return result;
    }

    private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        if (e.getCause() != null) {
            e = e.getCause();
        }
        ResultBean<?> result = new ResultBean();
        if (e instanceof CheckedException) {
            result.setMsg(e.getMessage());
            result.setCode(ResultBean.FAIL);
        } else if (e instanceof UnloginException) {
            ResponseUtils.setUnLoginStatus();
            result.setMsg("Unlogin");
            result.setCode(ResultBean.NO_LOGIN);
        } else {
            log.error(pjp.getSignature() + " error ", e);
            result.setMsg(e.toString());
            result.setCode(ResultBean.FAIL);
        }
        return result;
    }

    private ResultBean<?> handlerResponse(Object obj) {
        ResultBean<?> result;
        if (obj instanceof ResultBean) {
            result = (ResultBean<?>) obj;
        } else if (obj instanceof Page) {
            Page page = (Page) obj;
            result = new ResultBean<>(page.getContent());
            result.setToatlSize(page.getTotalElements());
            result.setPageNum(page.getNumber());
        } else {
            result = new ResultBean<>(obj);
        }
        return result;
    }
}
