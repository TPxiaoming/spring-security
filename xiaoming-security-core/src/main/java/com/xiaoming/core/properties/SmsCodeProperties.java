package com.xiaoming.core.properties;
/**
 * 图形验证码配置类
 * @author 江小明
 *
 */
public class SmsCodeProperties {

	private int length = 6; //验证码长度
	private int expireIn = 60; //有效时间 单位：秒
	private String url;
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getExpireIn() {
		return expireIn;
	}
	public void setExpireIn(int expireIn) {
		this.expireIn = expireIn;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
