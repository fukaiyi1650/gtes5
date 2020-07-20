package com.yitiankeji.commons.oauth2.interceptor;

import com.yitiankeji.commons.oauth2.RedisTokenStore;
import com.yitiankeji.commons.oauth2.session.Session;
import com.yitiankeji.commons.oauth2.utils.AccessTokenIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.yitiankeji.commons.oauth2.constants.ThreadLocalConstants.SESSION_THREAD_LOCAL;

@Component
@Order(-1)
public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTokenStore tokenStore;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Session session = SESSION_THREAD_LOCAL.get();
        if (session != null) {
            return true;
        }

        String access_token = AccessTokenIdUtil.getTokenId(request);
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(access_token);
        if (accessToken == null) {
            return true;
        }

        OAuth2Authentication authentication = tokenStore.readAuthentication(accessToken);
        if (authentication == null) {
            return true;
        }

        session = new Session(accessToken, authentication, tokenStore, access_token);
        SESSION_THREAD_LOCAL.set(session);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav) throws Exception {
        Session session = SESSION_THREAD_LOCAL.get();
        if (session != null) {
            session.storeToRedis();
            SESSION_THREAD_LOCAL.set(null);
        }
    }
}
