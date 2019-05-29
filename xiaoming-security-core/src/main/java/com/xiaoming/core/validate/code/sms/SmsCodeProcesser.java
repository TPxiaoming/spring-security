package com.xiaoming.core.validate.code.sms;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import com.xiaoming.core.validate.code.ValidateCode;
import com.xiaoming.core.validate.code.impl.AbstractValidateCodeProcessor;

/**
 * 短信验证码处理器
 * @author 江小明
 *
 */
@Component("smsCodeProcessor")
public class SmsCodeProcesser extends AbstractValidateCodeProcessor<ValidateCode> {

	@Autowired
	private SmsCodeSender smsCodeSender;
	
	@Override
	protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
		String mobile = ServletRequestUtils.getRequiredStringParameter((ServletRequest) request.getRequest(), "mobile");
		smsCodeSender.send(mobile, validateCode.getCode());
	}

	
}