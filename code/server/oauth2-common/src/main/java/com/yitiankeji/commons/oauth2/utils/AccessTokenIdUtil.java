package com.yitiankeji.commons.oauth2.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;

public class AccessTokenIdUtil {

    public static String getTokenId(NativeWebRequest request) {
        String access_token = request.getHeader("Authorization");
        if (StringUtils.startsWith(access_token, "Bearer")) {
            access_token = access_token.substring(6).trim();
        }
        if (access_token == null) {
            access_token = request.getParameter("access_token");
        }
        return access_token;
    }

    public static String getTokenId(HttpServletRequest request) {
        String access_token = request.getHeader("Authorization");
        if (StringUtils.startsWith(access_token, "Bearer")) {
            access_token = access_token.substring(6).trim();
        }
        if (access_token == null) {
            access_token = request.getParameter("access_token");
        }
        return access_token;
    }
}
