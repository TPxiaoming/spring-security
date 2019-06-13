package com.xiaoming.core.social.qq.connect;

import com.xiaoming.core.social.qq.api.QQ;
import com.xiaoming.core.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Template;

public class QQServiceProvider  extends AbstractOAuth2ServiceProvider<QQ> {

    private String appId;

    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

    public QQServiceProvider(String appId, String appSecrect) {
        //OAuth2Template 系统默认的
        //clientId：appId，clientSecrect：appSecrect在qq互连上注册应用时分配的，相当于app的用户名和密码
        //authorizeUrl：对应第一步将用户导向认证服务器，导向的Url
        //accessTokenUrl：对应第四步申请令牌的Url
        super(new OAuth2Template(appId, appSecrect, URL_AUTHORIZE ,URL_ACCESS_TOKEN));
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken, appId);
    }

}
