package com.xiaoming.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeGenerator {

	ValidateCode generator(ServletWebRequest request);
}
