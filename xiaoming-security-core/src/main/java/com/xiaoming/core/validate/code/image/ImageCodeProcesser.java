package com.xiaoming.core.validate.code.image;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import com.xiaoming.core.validate.code.impl.AbstractValidateCodeProcessor;

/**
 * 图片验证码处理器
 * @author 江小明
 *
 */
@Component("imageCodeProcessor")
public class ImageCodeProcesser extends AbstractValidateCodeProcessor<ImageCode> {

	@Override
	protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
		// TODO Auto-generated method stub
		//将生成的图片写到接口的响应中
        ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
	}

}
