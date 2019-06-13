package com.xiaoming.core.social.qq.connect;

import com.xiaoming.core.social.qq.api.QQ;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    /**
     * @param providerId      提供商的唯一标识，通过配置文件配进来
     * @param appId
     * @param appSecret
     */
    public QQConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
    }

}
