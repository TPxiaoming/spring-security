/**
 * 
 */
package com.xiaoming.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author 江小明
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void  whenQuerySuccess() throws Exception {
		//perform执行	
		mockMvc.perform(get("/user")//伪造请求
				.param("username", "xiaoming")
				.param("age", "18")
				.param("xxx", "yyy")
				.param("ageTo", "15")
//				.param("page", "3")	//当前页
//				.param("size", "15")	//页大小
//				.param("sort", "age,desc")	//排序
				.contentType(MediaType.APPLICATION_JSON_UTF8))//参数格式为UTF8
				.andExpect(status().isOk()) //期望 状态是OK
				.andExpect(jsonPath("$.length()").value(3));//返回的json内容 是个集合长度为3
	}	
}