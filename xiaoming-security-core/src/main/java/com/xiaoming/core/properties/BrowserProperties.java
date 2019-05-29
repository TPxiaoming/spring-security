package com.xiaoming.core.properties;

public class BrowserProperties {

	 private String loginPage="/xiaoming-signIn.html";  //默认登录页面

	   private LoginType loginType = LoginType.JSON;  //默认登录方式是返回JSON
	   
	   private int rememberMeSeconds = 3600;	//记住我的时间 一小时

	   public LoginType getLoginType() {
	      return loginType;
	   }

	   public void setLoginType(LoginType loginType) {
	      this.loginType = loginType;
	   }

	   public String getLoginPage() {
	      return loginPage;
	   }

	   public void setLoginPage(String loginPage) {
	      this.loginPage = loginPage;
	   }

		public int getRememberMeSeconds() {
			return rememberMeSeconds;
		}
	
		public void setRememberMeSeconds(int rememberMeSeconds) {
			this.rememberMeSeconds = rememberMeSeconds;
		}
		
	
}
