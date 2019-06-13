package com.xiaoming.core.social.qq.config;

import com.xiaoming.core.properties.QQProperties;
import com.xiaoming.core.properties.SecurityProperties;
import com.xiaoming.core.social.qq.connect.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
/**
 * @Author: xiaoming
 * @Date: 16:11 2019/6/12
 */
@Configuration
@ConditionalOnProperty(prefix = "xiaoming.security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qqProperties = securityProperties.getSocialProperties().getQqProperties();
        return new QQConnectionFactory(qqProperties.getProviderId(), qqProperties.getAppId(), qqProperties.getAppSecret());
    }
}
