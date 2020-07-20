package com.yitiankeji.commons.oauth2.config;

import com.yitiankeji.commons.oauth2.interceptor.SessionInterceptor;
import com.yitiankeji.commons.oauth2.resolver.AuthSessionMethodArgumentResolver;
import com.yitiankeji.commons.oauth2.resolver.AuthTokenMethodArgumentResolver;
import com.yitiankeji.commons.oauth2.resolver.TokenIdMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AuthTokenMethodArgumentResolver authTokenMethodArgumentResolver;
    @Autowired
    private AuthSessionMethodArgumentResolver authSessionMethodArgumentResolver;
    @Autowired
    private TokenIdMethodArgumentResolver tokenIdMethodArgumentResolver;

    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(authTokenMethodArgumentResolver);
        argumentResolvers.add(authSessionMethodArgumentResolver);
        argumentResolvers.add(tokenIdMethodArgumentResolver);
    }
}
