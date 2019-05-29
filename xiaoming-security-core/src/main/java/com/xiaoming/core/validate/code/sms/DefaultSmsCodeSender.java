package com.xiaoming.core.validate.code.sms;
/**
 * 默认发送短信验证码的实现
 * @author 江小明
 *
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

	@Override
	public void send(String mobile, String code) {
		System.out.println("向手机" + mobile + "发送短信验证码" + code);
	}

}
