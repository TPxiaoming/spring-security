package com.xiaoming.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码处理器， 封装不同校验码的处理逻辑
 * @author 江小明
 *
 */
public interface ValidateCodeProcessor {

	/**
	 * 验证码放入session时的前缀
	 */
	String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";
	
	/**
	 *  创建验证码
	 * @param request 工具类 包括 request 和  response
	 * @throws Exception
	 */
	void create(ServletWebRequest request) throws Exception;
}
