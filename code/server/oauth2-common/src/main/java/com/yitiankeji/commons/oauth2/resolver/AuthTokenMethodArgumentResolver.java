package com.yitiankeji.commons.oauth2.resolver;

import com.yitiankeji.commons.oauth2.RedisTokenStore;
import com.yitiankeji.commons.oauth2.utils.AccessTokenIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class AuthTokenMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private RedisTokenStore tokenStore;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(OAuth2AccessToken.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest request, WebDataBinderFactory binderFactory) throws Exception {
        String access_token = AccessTokenIdUtil.getTokenId(request);
        return tokenStore.readAccessToken(access_token);
    }
}
