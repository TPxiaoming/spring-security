package com.xiaoming.core;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.xiaoming.core.properties.SecurityProperties;
/**
 * 配置类
 * 使配置读取器生效
 * @author 江小明
 *
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

}
