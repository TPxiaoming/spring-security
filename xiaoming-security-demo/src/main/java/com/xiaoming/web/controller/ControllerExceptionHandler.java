package com.xiaoming.web.controller;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xiaoming.exception.UserNotExistException;

/**
 * 控制器错误处理器
 * @author 江小明
 *
 */
@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(UserNotExistException.class)	//要处理的异常类
	@ResponseBody	//返回值转成json
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)	//响应状态码
	public Map<String, Object> handlerUserNotExistException(UserNotExistException ex){
		Map<String, Object> result = new HashedMap();
		result.put("id", ex.getId());
		result.put("message", ex.getMessage());
		return result;
	}
}
