package com.xiaoming.core.validate.code.sms;
/**
 *  发送短信验证码接口
 * @author 江小明
 *
 */
public interface SmsCodeSender {

	void send(String mobile, String code);
}
