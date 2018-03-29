package com.github.fgowiki.config;

import com.github.fgowiki.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述：jwt配置
 *
 * @author 蒋经
 * @version 1.0
 * @since 2018/3/27
 */
@Deprecated
public class JwtConfig {

	@Bean
	public FilterRegistrationBean filterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean(new JwtFilter());
		registration.addUrlPatterns("/*");
		registration.setName("jwtFilter");
		registration.setOrder(1);
		registration.addInitParameter("exclusions","/login,*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return registration;
	}

}
