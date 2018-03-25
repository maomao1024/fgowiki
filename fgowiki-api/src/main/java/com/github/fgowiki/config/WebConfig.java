package com.github.fgowiki.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
  
    @Bean
    public HttpMessageConverters useConverters() {
        //指定使用fastjson
        return new HttpMessageConverters(new FastJsonHttpMessageConverter());
    }  
}  