package com.xiaoming.core.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * @Author: xiaoming
 * @Date: 16:08 2019/6/12
 */
@ConfigurationProperties(prefix = "xiaoming.security")	//会读取所有以com.xiaoming开头的配置项
public class SecurityProperties {

	private BrowserProperties browser = new BrowserProperties();
	
	private ValidateCodeProperties code = new ValidateCodeProperties();

	private SocialProperties socialProperties = new SocialProperties();

	public SocialProperties getSocialProperties() {
		return socialProperties;
	}

	public void setSocialProperties(SocialProperties socialProperties) {
		this.socialProperties = socialProperties;
	}

	public BrowserProperties getBrowser() {
		return browser;
	}

	public void setBrowser(BrowserProperties browser) {
		this.browser = browser;
	}

	public ValidateCodeProperties getCode() {
		return code;
	}

	public void setCode(ValidateCodeProperties code) {
		this.code = code;
	}

	
	
}
