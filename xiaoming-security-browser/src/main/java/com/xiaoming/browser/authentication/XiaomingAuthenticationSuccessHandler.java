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
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaoming.core.properties.LoginType;
import com.xiaoming.core.properties.SecurityProperties;
@Component("xmAuthenticationSuccessHandler")	//声明为spring的组件
public class XiaomingAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private Logger log = LoggerFactory.getLogger(XiaomingAuthenticationSuccessHandler.class);
	
	@Autowired
	private ObjectMapper objectMapper;  //springMvc启动的时候会注入一个ObjectMapper
	
	@Autowired
	private SecurityProperties securityProperties;

	
	/**
	 * 登录成功之后会被调用
	 * Authentication authentication 认证之后的信息
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("登录成功");
		
		if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
	         response.setContentType("application/json;charset=UTF-8");
	         response.getWriter().write(objectMapper.writeValueAsString(authentication));
	      } else {
	         super.onAuthenticationSuccess(request, response , authentication);
	      }
	}

}
