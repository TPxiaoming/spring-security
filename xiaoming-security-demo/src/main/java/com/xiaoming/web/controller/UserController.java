/**
 * 
 */
package com.xiaoming.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiaoming.dto.User;
import com.xiaoming.dto.UserQueryCondition;

/**
 * @author 江小明
 *
 */
@RestController
public class UserController {

	@RequestMapping(value = "/user", method = RequestMethod.GET)
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
}
