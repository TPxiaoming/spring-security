package com.xiaoming.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeGenerator {

	ImageCode generator(ServletWebRequest request);
}
