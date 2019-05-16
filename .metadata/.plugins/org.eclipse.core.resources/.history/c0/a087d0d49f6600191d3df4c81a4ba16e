package com.xiaoming.web.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.xiaoming.web.Interceptor.TimeInterceptor;
import com.xiaoming.web.filter.TimeFilter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	@Autowired
	private TimeInterceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor);
	}

	//将timeFilter加到过滤器链上 和在timeFilter上加Component注解是一样的
	@Bean
	public FilterRegistrationBean timeFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		
		TimeFilter timeFilter = new TimeFilter();
		registrationBean.setFilter(timeFilter);
		List<String> url = new ArrayList<String>();//配置这个过滤器在哪些url下起作用
		url.add("/*");//所有路径
		registrationBean.setUrlPatterns(url);
		return registrationBean;
	}
}
