package com.yitiankeji.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PathInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String urlPrefix = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        request.setAttribute("ctx", urlPrefix);
        return true;
    }
}
