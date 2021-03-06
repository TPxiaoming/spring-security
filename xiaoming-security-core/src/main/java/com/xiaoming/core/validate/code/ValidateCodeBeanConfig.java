package com.xiaoming.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xiaoming.core.properties.SecurityProperties;
import com.xiaoming.core.validate.code.image.ImageCodeGenerator;
import com.xiaoming.core.validate.code.sms.DefaultSmsCodeSender;
import com.xiaoming.core.validate.code.sms.SmsCodeSender;

@Configuration
public class ValidateCodeBeanConfig {
	
	@Autowired
	private SecurityProperties securityProperties;

	@Bean
	@ConditionalOnMissingBean(name = "imageCodeGenerator") //先去spring容器中找imageCodeGenerator
	public ValidateCodeGenerator imageCodeGenerator() {
		ImageCodeGenerator imageCodeGenerator = new ImageCodeGenerator();
		imageCodeGenerator.setSecurityProperties(securityProperties);
		return imageCodeGenerator;
	}
	
	@Bean
//	@ConditionalOnMissingBean(name = "smsCodeSender") //先去spring容器中找smsCodeSender
	@ConditionalOnMissingBean(SmsCodeSender.class)	//第二种写法
	public SmsCodeSender smsCodeSender() {
		
		return new DefaultSmsCodeSender();
	}
}
