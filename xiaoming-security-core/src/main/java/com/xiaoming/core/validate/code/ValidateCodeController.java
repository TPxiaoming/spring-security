package com.xiaoming.core.validate.code;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import com.xiaoming.core.properties.SecurityProperties;
import com.xiaoming.core.validate.code.image.ImageCode;
import com.xiaoming.core.validate.code.sms.SmsCodeSender;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

@RestController
public class ValidateCodeController {
	public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";
	
	@Autowired
	private Map<String, ValidateCodeProcessor> validateCodeProcessors;
	
	/**
	 * 创建验证码， 根据验证码类型不同， 调用不同的接口实现
	 * @param request
	 * @param response
	 * @param type
	 * @throws Exception
	 */
	@GetMapping("/code/{type}")
	public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception {
		validateCodeProcessors.get(type + "CodeProcessor").create(new ServletWebRequest(request, response));
	}
	

	/*
	 * public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";
	 * 
	 * private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	 * 
	 * @Autowired private ValidateCodeGenerator imageCodeGenerator;
	 * 
	 * @Autowired private ValidateCodeGenerator smsCodeGenerator;
	 * 
	 * @Autowired private SmsCodeSender smsCodeSender;
	 * 
	 * 
	 * @GetMapping("/code/image") public void createCode(HttpServletRequest request,
	 * HttpServletResponse response) throws IOException { //根据随机数生成图片验证码 ImageCode
	 * imageCode = (ImageCode) imageCodeGenerator.generator(new
	 * ServletWebRequest(request)); //将随机数存到Session中
	 * sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY,
	 * imageCode); //将生成的图片写到接口的响应中 ImageIO.write(imageCode.getImage(), "JPEG",
	 * response.getOutputStream()); }
	 * 
	 * 
	 * @GetMapping("/code/sms") public void createSmsCode(HttpServletRequest
	 * request, HttpServletResponse response) throws IOException,
	 * ServletRequestBindingException { //根据随机数生成验证码 ValidateCode smsCode =
	 * smsCodeGenerator.generator(new ServletWebRequest(request)); //将随机数存到Session中
	 * sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY,
	 * smsCode); //发送短信验证码 String mobile =
	 * ServletRequestUtils.getRequiredStringParameter(request, "mobile");
	 * smsCodeSender.send(mobile, smsCode.getCode()); }
	 */

}