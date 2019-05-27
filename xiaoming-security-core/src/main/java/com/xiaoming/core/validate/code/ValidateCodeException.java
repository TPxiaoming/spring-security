package com.xiaoming.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码异常
 * AuthenticationException 抽象异常， 身份认证异常的基类
 * @Author: xiaoming
 * @Date: 16:02 2019/5/27
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = 1850122820931656032L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}