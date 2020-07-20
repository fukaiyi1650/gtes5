package com.yitiankeji.commons.oauth2.session;

import com.yitiankeji.commons.oauth2.RedisTokenStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.Map;

@Getter
@AllArgsConstructor
public class Session {

    private final OAuth2AccessToken accessToken;
    private final OAuth2Authentication authentication;
    private final RedisTokenStore tokenStore;
    private final String id;

    public <T> T getAttribute(String name) {
        Map<String, Object> attributeMap = accessToken.getAdditionalInformation();
        return (T) attributeMap.get(name);
    }

    public <T> void setAttribute(String name, T value) {
        Map<String, Object> attributeMap = accessToken.getAdditionalInformation();
        attributeMap.put(name, value);
    }

    public void storeToRedis() {
        if (accessToken != null && authentication != null) {
            tokenStore.storeAccessToken(accessToken, authentication);
        }
    }
}
