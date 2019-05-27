package com.xiaoming.core.properties;
/**
 * 图形验证码配置类
 * @author 江小明
 *
 */
public class ImageCodeProperties {

	private int width = 67; //验证码图片宽度
	private int height = 23; //验证码图片高度
	private int length = 4; //验证码长度
	private int expireIn = 60; //有效时间 单位：秒
	private String url;
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
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
