package com.xiaoming.core.social.qq.api;

import org.apache.commons.lang.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

/**
 * @Author: xiaoming
 * @Date: 11:38 2019/6/6
 * 自定义获取用户信息流程  Api（AbstractOAuth2ApiBinding）
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {

    private String appId;

    private String openId;

    private static final  String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%S&openid=%s";

    public QQImpl(String accessToken, String appId){
        //自动处理将accessToken挂在请求头上
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;

        String url = String.format(URL_GET_OPENID, accessToken);
        String result = getRestTemplate().getForObject(url, String.class);
        System.out.println(result);

        this.openId = StringUtils.substringBetween(result, "\"openid\":","}");
    }

    @Override
    public QQUserInfo getUserInfo() {
        //发送请求获取用户信息
        String url = String.format(URL_GET_USERINFO, appId, openId);
        String result = getRestTemplate().getForObject(url, String.class);
        System.out.println(result);


        return null;
    }
}
