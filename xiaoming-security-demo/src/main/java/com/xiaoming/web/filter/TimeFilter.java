package com.xiaoming.web.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;
/**
 * 记录所有的服务的处理时间
 * @author 江小明
 *
 */
//@Component	注释掉了就成了一个普通的类，相当于是一个第三方的过滤器，加到过滤器链上
public class TimeFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("time filter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("time filter start");
		long start = new Date().getTime();
		//调用后续的过滤器
		chain.doFilter(request, response);
		System.out.println("time filter 耗时:"+ (new Date().getTime() - start));
		System.out.println("time filter finish");
	}

	@Override
	public void destroy() {
		System.out.println("time filter destroy");
	}

}
