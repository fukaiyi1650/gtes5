package com.yitiankeji.config;

import com.yitiankeji.interceptor.WeiXinOauth2Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private WeiXinOauth2Interceptor weiXinOauth2Interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(weiXinOauth2Interceptor);
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //setUseSuffixPatternMatch 后缀模式匹配
        configurer.setUseSuffixPatternMatch(true);
        //setUseTrailingSlashMatch 自动后缀路径模式匹配
        configurer.setUseTrailingSlashMatch(true);
    }
}
