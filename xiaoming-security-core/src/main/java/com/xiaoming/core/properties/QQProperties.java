package com.xiaoming.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;
/**
 * @Author: xiaoming
 * @Date: 16:03 2019/6/12
 */
public class QQProperties extends SocialProperties {
    private String providerId = "qq";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
