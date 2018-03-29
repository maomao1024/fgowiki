package com.github.fgowiki.filter;

import com.alibaba.druid.util.PatternMatcher;
import com.alibaba.druid.util.ServletPathMatcher;
import com.github.fgowiki.exception.CheckException;
import com.github.fgowiki.exception.UnloginException;
import com.github.fgowiki.utils.TokenUtils;
import com.google.common.base.Strings;
import org.springframework.core.annotation.Order;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 功能描述：
 *
 * @author 蒋经
 * @version 1.0
 * @since 2018/3/27
 */
public class JwtFilter implements Filter {

	private static final String AUTHORIZATION = "Authorization";
	private static final String BEARER = "Bearer";

	private Set<String> excludesPattern;
	protected PatternMatcher pathMatcher = new ServletPathMatcher();


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String exclusions = filterConfig.getInitParameter("exclusions");
		if (exclusions != null && exclusions.trim().length() != 0) {
			excludesPattern = new HashSet<>(Arrays.asList(exclusions.split("\\s*,\\s*")));
		}
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		if(isExclusion(httpRequest.getRequestURI())){
			chain.doFilter(request, response);
			return;
		}
		String auth = httpRequest.getHeader(AUTHORIZATION);
		if (Strings.isNullOrEmpty(auth) || !auth.startsWith(BEARER)) {
			throw new UnloginException("请登陆后再试");
		}
		String token = auth.substring(7, auth.length());
		if (TokenUtils.parse(token) != null) {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
	}

	public boolean isExclusion(String requestURI) {
		if (excludesPattern == null) {
			return false;
		}
		requestURI = requestURI.replaceAll("[/]+", "/");
		for (String pattern : excludesPattern) {
			if (pathMatcher.matches(pattern, requestURI)) {
				return true;
			}
		}
		return false;
	}
}
