/**
 * 
 */
package com.xiaoming.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.xiaoming.dto.User;
import com.xiaoming.dto.UserQueryCondition;

/**
 * @author 江小明
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@PostMapping
	public User create(@Valid @RequestBody User user, BindingResult errors) {
		if(errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
		}
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getId());
		System.out.println(user.getBirth());
		
		user.setId("1");
		return user;
	}

//	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@GetMapping
	@JsonView(User.UserSimpleView.class)
	public List<User> query(UserQueryCondition userQueryCondition,@PageableDefault(page = 2, size = 17, sort = "username,asc") Pageable pageable){
		System.out.println(ReflectionToStringBuilder.toString(userQueryCondition,ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(pageable.getPageSize());
		System.out.println(pageable.getPageNumber());
		System.out.println(pageable.getSort());
		List<User> users = new ArrayList<User>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;
	}
	
	//@PathVariable把url中的变量值传递到java方法中的参数里来
	//针对id写一个正则表达式 :\\d+ 表示只能接收数字
//	@RequestMapping(value = "/user/{id:\\d+}", method = RequestMethod.GET)
	@GetMapping("/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	public User getInfo(@PathVariable(name = "id") String id) {
		User user = new User();
		user.setUsername("tom");
		return user;
	}
}
