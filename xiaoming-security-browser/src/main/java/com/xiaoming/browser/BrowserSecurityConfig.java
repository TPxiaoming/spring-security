package com.xiaoming.browser;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.xiaoming.browser.authentication.XiaomingAuthenticationFailureHandler;
import com.xiaoming.core.properties.SecurityProperties;
import com.xiaoming.core.validate.code.ValidateCodeFilter;
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private SecurityProperties securityProperties;
	
	@Autowired
	private AuthenticationSuccessHandler xmAuthenticationSuccessHandler;
	
	@Autowired
	private XiaomingAuthenticationFailureHandler xmAuthenticationFailureHandler;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	/**
	 * 请记住我配置
	 * @return
	 */
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		//启动的时候系统自动建表
		//create table persistent_logins (username varchar(64) not null, series varchar(64) primary key, token varchar(64) not null, last_used timestamp not null)
		//tokenRepository.setCreateTableOnStartup(true); 只要第一次启动的时候创建
		return tokenRepository;
	}
	
	
	 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
		validateCodeFilter.setAuthenticationFailureHandler(xmAuthenticationFailureHandler);
		validateCodeFilter.setSecurityProperties(securityProperties);
		validateCodeFilter.afterPropertiesSet();
		
		http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
			.formLogin()	//表单登录
			.loginPage("/authentication/require") 	//自定义登录页面
			.loginProcessingUrl("/authentication/form")
			.successHandler(xmAuthenticationSuccessHandler)	//自定义成功处理
			.failureHandler(xmAuthenticationFailureHandler) //自定义失败处理
			.and()
			.rememberMe() //记住我功能
			.tokenRepository(persistentTokenRepository())	//记住我的配置
			.tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())	//记住我的时间
			.userDetailsService(userDetailsService)	//用户信息
			.and()
			.authorizeRequests()	//授权
			.antMatchers("/authentication/require",
					securityProperties.getBrowser().getLoginPage(),
					"/code/*").permitAll()	//这个页面不需要身份认证
			.anyRequest()	//任何请求
			.authenticated()	//需要认证
			.and()
			.csrf().disable();	//跨站伪造请求
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();		//自己定义的加密方式	这种方式对于相同密码得出的密文都不一样
	}

}
