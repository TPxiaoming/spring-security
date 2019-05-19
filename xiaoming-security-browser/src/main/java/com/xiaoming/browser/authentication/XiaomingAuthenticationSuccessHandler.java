package com.xiaoming.browser.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
@Component("xmAuthenticationSuccessHandler")	//声明为spring的组件
public class XiaomingAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private Logger log = LoggerFactory.getLogger(XiaomingAuthenticationSuccessHandler.class);
	
	@Autowired
	private ObjectMapper objectMapper;
	/**
	 * 登录成功之后会被调用
	 * Authentication authentication 认证之后的信息
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("登录成功");
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(objectMapper.writeValueAsString(authentication));
	}

}
