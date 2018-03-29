package com.github.fgowiki.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletResponse;

/**
 * 功能描述：
 *
 * @author 蒋经
 * @version 1.0
 * @since 2018/3/29
 */
public abstract class ResponseUtils {

	public static HttpServletResponse getResponse() {
		return ((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse();
	}

	public static void setUnLoginStatus() {
		getResponse().setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	}
}
