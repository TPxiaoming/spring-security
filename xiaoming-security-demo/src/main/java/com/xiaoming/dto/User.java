/**
 * 
 */
package com.xiaoming.dto;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author 江小明
 *
 */
public class User {

	public interface UserSimpleView {};
	public interface UserDetailView extends UserSimpleView{};
	
	private String username;
	@NotBlank
	private String password;
	private String id;
	private Date birth;
	
	@JsonView(UserSimpleView.class)
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@JsonView(UserSimpleView.class)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@JsonView(UserSimpleView.class)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@JsonView(UserDetailView.class)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
