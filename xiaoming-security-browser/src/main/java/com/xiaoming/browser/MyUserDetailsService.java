package com.xiaoming.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("用户名" + username);
		//根据用户名查找用户信息
		//根据查找到的用户信息判断用户是否被冻结
		//passwordEncoder.encode("123456")应该是在注册的时候做的，然后这里自己给数据库的密码就可以了
        String password = passwordEncoder.encode("123456");
        logger.info("数据库密码是：" + password);
		return new User(username,password, 
				true, true, true, true, 
				AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}

}