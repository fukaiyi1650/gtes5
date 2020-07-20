package com.yitiankeji.commons.oauth2.service;

import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

import static com.yitiankeji.commons.oauth2.constants.ThreadLocalConstants.SESSION_THREAD_LOCAL;

public class ThreadLocalTokeServices extends DefaultTokenServices {

    @Override
    public boolean revokeToken(String tokenValue) {
        if (tokenValue == null) {
            return false;
        }
        boolean result = super.revokeToken(tokenValue);
        if (result) {
            SESSION_THREAD_LOCAL.set(null);
        }
        return result;
    }
}
