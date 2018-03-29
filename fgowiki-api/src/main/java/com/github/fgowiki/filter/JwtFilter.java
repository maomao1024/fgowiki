package com.github.fgowiki.filter;

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

	private String[] excludedPageArray={"login"};


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String excludedPages = filterConfig.getInitParameter("EXCLUDED_PAGES");
		if (!Strings.isNullOrEmpty(excludedPages)) { // 例外页面不为空
			excludedPageArray = excludedPages.split(String.valueOf(';'));
		}
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		if(isExcludedPage(httpRequest)){
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
		this.excludedPageArray = null;
	}

	private boolean isExcludedPage(HttpServletRequest request){
		for (String page : excludedPageArray) {// 遍历例外url数组
			// 判断当前URL是否与例外页面相同
			if(request.getServletPath().replaceAll("/","").equals(page)){ // 从第2个字符开始取（把前面的/去掉）
				return true;
			}
		}
		return false;
	}
}
