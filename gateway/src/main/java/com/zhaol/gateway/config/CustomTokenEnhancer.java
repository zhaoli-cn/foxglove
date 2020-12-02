package com.zhaol.gateway.config;

import com.zhaol.common.constant.TokenConstant;
import com.zhaol.gateway.entity.MyUser;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义令牌增强器
 *
 * @version 1.0
 * @author: 赵力
 * @创建时间:2020/12/2 15:02
 */
public class CustomTokenEnhancer implements TokenEnhancer {

    /**
     * 封装扩展用户信息
     * @param oAuth2AccessToken
     * @param oAuth2Authentication
     * @return org.springframework.security.oauth2.common.OAuth2AccessToken
     * @author 赵力
     * @date 2020-12-02 15:22:46
    */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String, Object> info = new HashMap<>();
        MyUser user = (MyUser) oAuth2Authentication.getPrincipal();
        oAuth2Authentication.getPrincipal();
        info.put(TokenConstant.JWT_EXT, "JWT 扩展信息");
        info.put(TokenConstant.USER_ID,user.getId());
        info.put(TokenConstant.USER_MOBILE,user.getMobile());
        info.put(TokenConstant.USER_NAME,user.getName());
        info.put(TokenConstant.USER_IDENTITY,user.getIdentity());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);
        return oAuth2AccessToken;
    }
}
