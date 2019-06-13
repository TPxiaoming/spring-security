package com.xiaoming.core.social.qq.connect;

import com.xiaoming.core.social.qq.api.QQ;
import com.xiaoming.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @Author: xiaoming
 * @Date: 9:58 2019/6/10
 * 通过 ApiAdapter 将用户信息转换成Connection标准的数据结构
 * Connection封装的是服务提供商的用户信息，数据库中的业务用户信息如何和服务提供商的用户对应，对应关系存在数据库中 UserConnection表中
 * UserConnectionRepository（JdbcUsersConnectionRespository）操纵UserConnection表
 */
public class QQAdapter implements ApiAdapter<QQ> {
    /**
     * 测试当前 api 是否可用
     * @param qq
     * @return
     */
    @Override
    public boolean test(QQ qq) {
        //不去调用是否是可用的，默认永远是通的
        return true;
    }

    /**
     * api数据与connection数据间进行适配
     * @param qq
     * @param connectionValues 包含了创建一个ConnectionFactory所需要的数据项
     */
    @Override
    public void setConnectionValues(QQ qq, ConnectionValues connectionValues) {
        //1.获取QQ信息
        QQUserInfo userInfo = qq.getUserInfo();
        //2.将QQ信息放进ConnectionValues中
        connectionValues.setDisplayName(userInfo.getNickname());
        connectionValues.setImageUrl(userInfo.getFigureurl_qq_1());
        connectionValues.setProfileUrl(null);//个人主页
        connectionValues.setProviderUserId(userInfo.getOpenId());//服务商的用户Id
    }

    /**
     *
     * @param qq
     * @return
     */
    @Override
    public UserProfile fetchUserProfile(QQ qq) {
        return null;
    }

    /**
     * qq使用不到，比如：微博，某些社交网站才会使用，发送消息更新状态
     * 这里我们什么都不做
     * @param qq
     * @param s
     */
    @Override
    public void updateStatus(QQ qq, String s) {

    }
}
