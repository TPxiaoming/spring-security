package com.xiaoming.service.impl;

import org.springframework.stereotype.Service;

import com.xiaoming.service.HelloService;
@Service
public class HelloServiceImpl implements HelloService{

	@Override
	public String greeting(String name) {
		System.out.println("greeting");
		return "hello"+name;
	}

	
}
