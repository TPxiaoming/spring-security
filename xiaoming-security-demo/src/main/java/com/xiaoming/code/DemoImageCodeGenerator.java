package com.xiaoming.code;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import com.xiaoming.core.validate.code.ImageCode;
import com.xiaoming.core.validate.code.ValidateCodeGenerator;
@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

	@Override
	public ImageCode generator(ServletWebRequest request) {
		System.out.println("更高级的图形验证码生成代码");
		//自定义的验证码生成逻辑
		return null;
	}

}
