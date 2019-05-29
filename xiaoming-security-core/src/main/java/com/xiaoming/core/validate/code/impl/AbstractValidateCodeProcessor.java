package com.xiaoming.core.validate.code.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import com.xiaoming.core.validate.code.ValidateCodeGenerator;
import com.xiaoming.core.validate.code.ValidateCodeProcessor;

public abstract class AbstractValidateCodeProcessor<C> implements ValidateCodeProcessor {

	/**
	 * 操作session的工具类
	 */
	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	
	/**
	 * 收集系统中所有的 ValidateCodeGenerator 接口的实现
	 */
	@Autowired
	private Map<String, ValidateCodeGenerator> validateCodeGenerators;
	
	@Override
	public void create(ServletWebRequest request) throws Exception {
		C validateCode = generate(request);
		save(request, validateCode);
		send(request, validateCode);
	}

	
	/**
	 * 发送验证码，由子类实现
	 * @param request
	 * @param validateCode
	 */
	protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;



	/**
	 * 将验证码保存到session中
	 * @param request
	 * @param validateCode
	 */
	protected void save(ServletWebRequest request, C validateCode) {
		sessionStrategy.setAttribute(request, SESSION_KEY_PREFIX + getProcessorType(request), validateCode);
	}



	/**
	 * 生成验证码
	 * @param request
	 * @return
	 */
	protected C generate(ServletWebRequest request) {
		String type = getProcessorType(request);
		ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(type + "CodeGenerator");
		return (C) validateCodeGenerator.generator(request);
	}



	/**
	 * 根据请求的url获取验证码的类型
	 * @param request
	 * @return
	 */
	private String getProcessorType(ServletWebRequest request) {
		return StringUtils.substringAfter(request.getRequest().getRequestURI(), "/code/");
	}
}