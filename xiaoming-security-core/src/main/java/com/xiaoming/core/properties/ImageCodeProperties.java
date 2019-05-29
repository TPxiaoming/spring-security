package com.xiaoming.core.properties;
/**
 * 图形验证码配置类
 * @author 江小明
 *
 */
public class ImageCodeProperties extends SmsCodeProperties{
	

	private int width = 67; //验证码图片宽度
	private int height = 23; //验证码图片高度
	
	public ImageCodeProperties() {
		setLength(4);
	}
	
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
	
}
